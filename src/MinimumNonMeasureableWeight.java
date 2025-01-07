import java.util.*;
public class MinimumNonMeasureableWeight {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = in.nextInt();
        }

        Arrays.sort(weights);
        int measurement = 1;

        for (int index = 0; index < N; index++) {
            if (weights[index] <= measurement) {
                measurement += weights[index];
            } else {
                break;
            }
        }

        System.out.print(measurement);

    }
}
