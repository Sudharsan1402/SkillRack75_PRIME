import java.util.*;
public class TollGateCollection {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        int K = in.nextInt();
        int [] result = new int[1];
        int [] tollDist = new int[K];
        int [] tollfare = new int[K];
        for (int i = 0; i < K; i++) {
            tollDist[i] = in.nextInt();
        }
        for (int i = 0; i < K; i++) {
            tollfare[i] = in.nextInt();
        }
        getMaxCollections(N, D, K, tollDist, tollfare, result);
        System.out.print(result[0]);

    }

    private static void getMaxCollections(int kms, int gap, int tolls, int[] tollDist, int[] tollfare,
                                          int[] result) {

        int [] revenue = new int[kms + 1];
        revenue[0] = 0;
        int tollIndex = 0;
        for (int km = 1; km <= kms; km++) {
            if (tollIndex < tolls && tollDist[tollIndex] == km) {
                if (km <= gap) {
                    revenue[km] = Math.max(revenue[km - 1], tollfare[tollIndex]);
                } else {
                    revenue[km] = Math.max(revenue[km - 1], tollfare[tollIndex] + revenue[km - gap - 1]);
                }
                tollIndex++;
                if(tollIndex == tolls){
                    result[0] = revenue[km];
                    return;
                }
            } else {
                revenue[km] = revenue[km - 1];
            }
        }
    }
}
