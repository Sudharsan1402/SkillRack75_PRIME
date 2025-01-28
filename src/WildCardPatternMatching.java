import java.util.*;
public class WildCardPatternMatching {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String pattern = in.nextLine();
        int R = text.length();
        int C = pattern.length();
        boolean[][] matrix = new boolean[R + 1][C + 1];

        matrix[0][0] = true;
        if (pattern.charAt(0) == '*') {
            matrix[0][1] = true;
        }

        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                if (pattern.charAt(col - 1) == '?' || pattern.charAt(col - 1) == text.charAt(row - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1];
                } else if (pattern.charAt(col - 1) == '*') {
                    matrix[row][col] = matrix[row - 1][col] || matrix[row][col - 1];
                }
            }
        }

        System.out.print(matrix[R][C] ? "Matching" : "Not matching");

    }
}
