import java.util.*;
public class SubsetCountCombinationforEvenSum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        int totalSum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            totalSum += arr[i];
        }

        Arrays.sort(arr);
        boolean[][] matrix = new boolean[N + 1][totalSum + 1];

        for (int row = 1; row <= N; row++) {
            int curr = arr[row - 1];

            for (int sum = 0; sum <= totalSum; sum++) {
                if (sum >= curr && (sum == curr || matrix[row - 1][sum - curr])) {
                    matrix[row][sum] = true;
                } else {
                    matrix[row][sum] = matrix[row - 1][sum];
                }
            }
        }

        int count = 0;

        for (int sum = 2; sum <= totalSum; sum += 2) {
            if (matrix[N][sum]) {
                count++;
            }
        }

        System.out.print(count);

    }
}
