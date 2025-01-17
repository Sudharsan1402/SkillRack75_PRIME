import java.util.*;
public class PowerPointsSplit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N + 1];

        for (int index = 1; index <= N; index++) {
            arr[index] = 0;
        }
        arr[1] = 1;

        for (int sum = 2; sum <= N; sum++) {
            for (int singlePart = 1; singlePart < sum; singlePart++) {
                int remPartSum = sum - singlePart;
                int currProdMax = singlePart * Math.max(remPartSum, arr[remPartSum]);
                arr[sum] = Math.max(arr[sum], currProdMax);
            }
        }

        System.out.print(arr[N]);


    }
}
