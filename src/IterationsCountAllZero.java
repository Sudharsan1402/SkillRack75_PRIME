import java.util.*;
public class IterationsCountAllZero {
    public static int iterations = 0;
    public static int R;
    public static int C;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();

        int[][] matrix = new int[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                matrix[row][col] = in.nextInt();
            }
        }

        int K = in.nextInt();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (matrix[row][col] >= K) {
                    iterations++;
                    traverse(matrix, row, col);
                }
            }
        }
        System.out.println(iterations);

    }

    private static void traverse(int[][] matrix, int row, int col) {
        if (row >= 0 && row < R && col >= 0 && col < C) {
            if (matrix[row][col] == 0) {
                return;
            }
            matrix[row][col] = 0;

            traverse(matrix, row - 1, col);
            traverse(matrix, row + 1, col);
            traverse(matrix, row, col - 1);
            traverse(matrix, row, col + 1);
        }
    }

}
