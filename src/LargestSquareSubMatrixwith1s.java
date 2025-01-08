import java.util.*;
public class LargestSquareSubMatrixwith1s {

    private static int min(int x, int y) {
        return x < y ? x : y;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int R = in.nextInt(); // Number of rows
        int C = in.nextInt(); // Number of columns

        // Create a 2D array to store the input matrix
        int[][] matrix = new int[R][C];

        // Create a 2D array to store the maximum size of the square submatrix ending at each cell
        int[][] max = new int[R][C];
        int maxSize = 0; // To store the maximum size found

        // Read the input matrix
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                matrix[row][col] = in.nextInt();

                // Initialize max[row][col] with the value at the current cell
                if(row==0 || col==0){
                    max[row][col] = matrix[row][col];
                }

                // If the current cell value is 1, the maximum size is at least 1
                if (matrix[row][col] == 1) {
                    maxSize = 1;
                }
            }
        }

        // Calculate the maximum size of the square submatrix ending at each cell
        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                // If the current cell value is 0, the maximum size is 0
                if (matrix[row][col] == 0) {
                    max[row][col] = 0;
                    continue; // Skip to the next cell
                }

                // Calculate the maximum sizes of the submatrices to the left, top, and top-left
                int left = max[row][col - 1];
                int top = max[row - 1][col];
                int topLeft = max[row - 1][col - 1];

                // Calculate the maximum size of the current submatrix
                max[row][col] = min(left, min(top, topLeft)) + 1;

                // Update the maximum size found
                if (max[row][col] > maxSize) {
                    maxSize = max[row][col];
                }
            }
        }

        // Print the maximum size of the largest square submatrix
        System.out.print(maxSize);

    }
}
