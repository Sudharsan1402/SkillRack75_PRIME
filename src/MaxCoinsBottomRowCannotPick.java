import java.util.*;
public class MaxCoinsBottomRowCannotPick {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[r][c];
            for (int i = 0; i < c; i++) {
                dp[0][i] = matrix[0][i];
            }

            for (int i = 1; i < r; i++) {
                int[] prevrow = Arrays.copyOf(dp[i - 1], c);
                Arrays.sort(prevrow);

                int firstmax = prevrow[c - 1];
                int secondmax = prevrow[c - 2];

                for (int j = 0; j < c; j++) {
                    if (dp[i - 1][j] != firstmax) {
                        dp[i][j] = firstmax + matrix[i][j];
                    } else {
                        dp[i][j] = secondmax + matrix[i][j];
                    }
                }
            }

            Arrays.sort(dp[r - 1]);
            System.out.println(dp[r - 1][c - 1]);
        }

    }
}
