import java.util.*;
public class CherryPickup2 {


    static int[][][] dp;

    public static int cherryPickup(int[][] grid, int n) {
        dp = new int[n][n][n];

        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        int cherries = solve(grid, n, 0, 0, 0, 0);
        return Math.max(0, cherries);
    }

    public static int solve(int[][] grid, int n, int r1, int c1, int r2, int c2) {
        if (r1 >= n || r2 >= n || c2 >= n || c1 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][c2] != -1) {
            return dp[r1][c1][c2];
        }

        int value = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            value += grid[r2][c2];
        }

        int rr = solve(grid, n, r1, c1 + 1, r2, c2 + 1);
        int rd = solve(grid, n, r1, c1 + 1, r2 + 1, c2);
        int dr = solve(grid, n, r1 + 1, c1, r2, c2 + 1);
        int dd = solve(grid, n, r1 + 1, c1, r2 + 1, c2);

        dp[r1][c1][c2] = value + Math.max(Math.max(rr, rd), Math.max(dr, dd));

        return dp[r1][c1][c2];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        System.out.println(cherryPickup(grid, n));
    }
}
