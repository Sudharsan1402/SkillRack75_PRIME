import java.util.*;
public class PathfromSourcetoDestination {
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

        int src1 = in.nextInt();
        int src2 = in.nextInt();

        int dest1 = in.nextInt();
        int dest2 = in.nextInt();

        boolean[] found = new boolean[1];

        if (matrix[src1][src2] == 0 || matrix[dest1][dest2] == 0) {
            System.out.print("no");
            return;
        }

        traverse(matrix, src1, src2, dest1, dest2, R, C, found);
        System.out.print(found[0] ? "yes" : "no");

    }

    private static void traverse(int[][] matrix, int src1, int src2, int dest1, int dest2, int R, int C, boolean[] found) {
        if (src1 >= 0 && src1 < R && src2 >= 0 && src2 < C) {
            if (src1 == dest1 && src2 == dest2) {
                found[0] = true;
                return;
            }

            if (matrix[src1][src2] == 2) {
                return;
            }

            matrix[src1][src2] = 2;

            traverse(matrix, src1, src2 - 1, dest1, dest2, R, C, found);
            if (found[0]) {
                return;
            }

            traverse(matrix, src1 - 1, src2, dest1, dest2, R, C, found);
            if (found[0]) {
                return;
            }

            traverse(matrix, src1 + 1, src2, dest1, dest2, R, C, found);
            if (found[0]) {
                return;
            }

            traverse(matrix, src1, src2 + 1, dest1, dest2, R, C, found);
        }
    }
}
