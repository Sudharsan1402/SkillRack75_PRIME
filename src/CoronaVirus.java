import java.util.*;
public class CoronaVirus {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();
        int matrix [][] = new int[R][C];
        int healthy = 0;
        int days = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                matrix[row][col] = in.nextInt();
                if (matrix[row][col] == 1) {
                    healthy++;
                }
                if (matrix[row][col] == 2) {
                    queue.add(row * C + col);
                }

            }
        }

        queue.add(-1);
        while (!queue.isEmpty()) {

            int node = queue.poll();
            if (node == -1) {
                if (!queue.isEmpty()) {
                    days++;
                    queue.add(-1);
                }
                continue;

            }
            int row = node / C;
            int col = node % C;

            if (col > 0 && matrix[row][col - 1] == 1) {
                matrix[row][col - 1] = 2;
                queue.add(row * C + col - 1);
                healthy--;
            }
            if (col < C - 1 && matrix[row][col + 1] == 1) {
                matrix[row][col + 1] = 2;
                queue.add(row * C + col + 1);
                healthy--;
            }
            if (row > 0 && matrix[row - 1][col] == 1) {
                matrix[row - 1][col] = 2;
                queue.add((row - 1) * C + col);
                healthy--;

            }
            if (row < R - 1 && matrix[row + 1][col] == 1) {
                matrix[row + 1][col] = 2;
                queue.add((row + 1) * C + col);
                healthy--;

            }
        }
        System.out.print(healthy == 0 ? days : -1);

    }
}
