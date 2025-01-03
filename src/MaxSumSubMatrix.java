import java.util.*;
public class MaxSumSubMatrix {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int R = in.nextInt();
        int C = in.nextInt();

        int[][] matrix = new int[R][C + 1];

        for (int row = 0; row < R; row++) {
            for (int col = 1; col <= C; col++) {
                int curr = in.nextInt();
                matrix[row][col] = curr + matrix[row][col - 1];
            }
        }

        int K = in.nextInt();

        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row <= R - K; row++) {
            for (int col = 1; col <= C - K + 1; col++) {
                int sum = 0;
                for (int srow = row; srow < row + K; srow++) {
                    sum += matrix[srow][col + K - 1] - matrix[srow][col - 1];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.print(maxSum);

    }
}
