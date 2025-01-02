import java.util.*;
public class IslandCount {
    public static int R, C;

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

        int islandCount = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (matrix[row][col] == 1) {
                    islandCount++;
                    traverse(matrix, row, col);
                }
            }
        }

        System.out.print(islandCount);

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
            traverse(matrix, row - 1, col - 1);
            traverse(matrix, row - 1, col + 1);
            traverse(matrix, row + 1, col - 1);
            traverse(matrix, row + 1, col + 1);
        }
    }
}
