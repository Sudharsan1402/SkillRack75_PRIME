import java.util.*;
public class MinimumEditDistanceTwoStrings {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int[][] matrix = new int[str2.length() + 1][str1.length() + 1];

        for (int col = 0; col <= str1.length(); col++) {
            matrix[0][col] = col;
        }

        for (int row = 0; row <= str2.length(); row++) {
            matrix[row][0] = row;
        }

        for (int row = 1; row <= str2.length(); row++) {
            for (int col = 1; col <= str1.length(); col++) {
                if (str1.charAt(col - 1) == str2.charAt(row - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1];
                } else {
                    int left = matrix[row][col - 1];
                    int top = matrix[row - 1][col];
                    int topLeft = matrix[row - 1][col - 1];
                    matrix[row][col] = 1 + Math.min(topLeft, Math.min(top, left));
                }
            }
        }

        System.out.print(matrix[str2.length()][str1.length()]);

    }
}
