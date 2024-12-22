import java.util.*;
public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        int R = str1.length();
        int C = str2.length();

        int[][] matrix = new int[R][C];
        int maxlen = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (str1.charAt(row) == str2.charAt(col)) {
                    matrix[row][col] = (row == 0 || col == 0) ? 1 : 1 + matrix[row - 1][col - 1];

                    if (matrix[row][col] > maxlen) {
                        maxlen = matrix[row][col];
                    }
                } else {
                    matrix[row][col] = 0;
                }
            }
        }

        System.out.print(maxlen);

    }
}
