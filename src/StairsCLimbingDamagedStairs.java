import java.util.*;
public class StairsCLimbingDamagedStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int T = in.nextInt();
        int[] leaps = new int[S];
        for (int i = 0; i < S; i++) {
            leaps[i] = in.nextInt();
        }
        List<Integer> damaged = new ArrayList<>();
        for (int i = 1; i <= T; i++) {
            damaged.add(in.nextInt());
        }
        long[] ways = new long[N + 1];
        ways[0] = 1;
        for (int step = 1; step <= N; step++) {
            if (damaged.contains(step)) {
                ways[step] = 0;
                continue;
            }
            for (int index = 0; index < S; index++) {
                if (step >= leaps[index]) {
                    ways[step] += ways[step - leaps[index]];
                }
            }
        }
        System.out.print(ways[N]);

    }
}
