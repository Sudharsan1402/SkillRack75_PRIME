import java.util.*;
public class Safe_Walk_Through_Grid {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), h = in.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solve(arr, n, m, h));
    }

    public static boolean solve(int[][] arr, int n, int m, int h) {
        if (h >= n + m - 1) return true;

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][][] vis = new boolean[n][m][h + 1];
        h -= arr[0][0];

        if (h < 0) return false;

        que.add(new int[]{0, 0, h});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0], c = cur[1], h_rem = cur[2];

            if (r == n - 1 && c == m - 1) return true;

            if (vis[r][c][h_rem]) continue;
            vis[r][c][h_rem] = true;

            int[] adjR = {1, -1, 0, 0};
            int[] adjC = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int row = r + adjR[i], col = c + adjC[i];

                if (row >= 0 && row < n && col >= 0 && col < m && h_rem - arr[row][col] >= 1) {
                    que.add(new int[]{row, col, h_rem - arr[row][col]});
                }
            }
        }
        return false;
    }
}
