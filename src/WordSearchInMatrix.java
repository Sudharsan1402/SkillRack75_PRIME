import java.util.*;
public class WordSearchInMatrix {
    public static int R, C, found = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();
        char[][] matrix = new char[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                matrix[row][col] = in.next().charAt(0);
            }
        }

        String s = in.next();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (matrix[row][col] == s.charAt(0)) {
                    search(matrix, row, col, s, 0);
                }
                if (found == 1) {
                    System.out.print("yes");
                    return;
                }
            }
        }
        System.out.print("no");

    }

    private static void search(char[][] matrix, int row, int col, String s, int index) {
        if (row >= 0 && row < R && col >= 0 && col < C) {
            if (index == s.length()) {
                found = 1;
                return;
            }
            if (s.charAt(index) == matrix[row][col]) {
                char backup = matrix[row][col];
                matrix[row][col] = '-';

                search(matrix, row + 1, col, s, index + 1);
                search(matrix, row - 1, col, s, index + 1);
                search(matrix, row, col + 1, s, index + 1);
                search(matrix, row, col - 1, s, index + 1);

                matrix[row][col] = backup;
            }
        }
    }

}
