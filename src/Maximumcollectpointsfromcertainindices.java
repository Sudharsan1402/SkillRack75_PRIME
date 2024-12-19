import java.util.*;
public class Maximumcollectpointsfromcertainindices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int R = in.nextInt();
        int C = in.nextInt();

        int[][] matrix = new int[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                matrix[row][col] = in.nextInt();
            }
        }

        int startRow = in.nextInt();
        int startCol = in.nextInt();

        int[][] max = new int[R][C];
        max[startRow][startCol] = matrix[startRow][startCol];

        for (int col = startCol + 1; col < C; col++) {
            max[startRow][col] = max[startRow][col - 1] + matrix[startRow][col];
        }

        for (int row = startRow + 1; row < R; row++) {
            max[row][startCol] = max[row - 1][startCol] + matrix[row][startCol];
        }

        for (int row = startRow + 1; row < R; row++) {
            for (int col = startCol + 1; col < C; col++) {
                max[row][col] = Math.max(max[row - 1][col], max[row][col - 1]) + matrix[row][col];
            }
        }

        System.out.print(max[R - 1][C - 1]);

    }
}
