import java.util.*;
public class MinimumSwapsfrom1toNindescendingorder {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N + 1];
        for (int i = N; i >= 1; i--) {
            arr[i] = in.nextInt();
        }

        int totalSwaps = 0;
        boolean[] visited = new boolean[N + 1];

        for (int index = 1; index <= N; index++) {
            if (visited[arr[index]]) {
                continue;
            }

            if (arr[index] == index) {
                visited[arr[index]] = true;
                continue;
            }

            int edges = 0, cycleIndex = index;
            while (!visited[arr[cycleIndex]]) {
                visited[arr[cycleIndex]] = true;
                edges++;
                cycleIndex = arr[cycleIndex];
            }

            totalSwaps += edges - 1;
        }

        System.out.print(totalSwaps);

    }
}
