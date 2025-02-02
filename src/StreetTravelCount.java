import java.util.*;
public class StreetTravelCount {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                matrix[row][col] = in.nextInt();
            }
        }

        int source = in.nextInt() * N + in.nextInt();
        int destination = in.nextInt() * N + in.nextInt();
        boolean[] visited = new boolean[N * N];
        int[] streets = new int[N * N];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> related = getRelated(matrix, node, N);
            for (Integer relNode : related) {
                if (!visited[relNode]) {
                    queue.add(relNode);
                    visited[relNode] = true;
                    streets[relNode] = 1 + streets[node];
                    if (relNode == destination) {
                        System.out.print(streets[relNode]);
                        return;
                    }
                }
            }
        }
        System.out.print(streets[destination]);

    }

    private static List<Integer> getRelated(int[][] matrix, int node, int N) {
        List<Integer> nodes = new ArrayList<>();
        int nodeRow = node / N, nodeCol = node % N;

        for (int col = nodeCol - 1; col >= 0; col--) {
            if (matrix[nodeRow][col] == 1) {
                nodes.add(nodeRow * N + col);
            } else {
                break;
            }
        }

        for (int col = nodeCol + 1; col < N; col++) {
            if (matrix[nodeRow][col] == 1) {
                nodes.add(nodeRow * N + col);
            } else {
                break;
            }
        }

        for (int row = nodeRow - 1; row >= 0; row--) {
            if (matrix[row][nodeCol] == 1) {
                nodes.add(row * N + nodeCol);
            } else {
                break;
            }
        }

        for (int row = nodeRow + 1; row < N; row++) {
            if (matrix[row][nodeCol] == 1) {
                nodes.add(row * N + nodeCol);
            } else {
                break;
            }
        }

        return nodes;
    }
}
