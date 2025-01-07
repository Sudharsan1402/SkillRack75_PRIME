import java.util.*;
public class DpEqualArraySumLeftandRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N + 1];
        long[] sumArr = new long[N + 1];

        for (int index = 1; index <= N; index++) {
            arr[index] = in.nextInt();
            sumArr[index] = sumArr[index - 1] + arr[index];
        }

        long totalSum = sumArr[N];

        for (int index = 1; index <= N; index++) {
            if (sumArr[index - 1] + arr[index] == totalSum - sumArr[index]) {
                System.out.print(arr[index]);
            }
        }

    }
}
