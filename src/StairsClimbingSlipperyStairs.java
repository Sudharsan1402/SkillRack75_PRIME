import java.util.*;
public class StairsClimbingSlipperyStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int T = in.nextInt();
        int[] leaps = new int[S];
        for (int i = 0; i < S; i++) {
            leaps[i] = in.nextInt();
        }
        List<Integer> slippery = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            slippery.add(in.nextInt());
        }
        long[] ways = new long[N + 1];
        ways[0] = 1;
        for (int step = 1; step <= N; step++) {
            for (int index = 0; index < S; index++) {
                if (step >= leaps[index]) {
                    ways[step] += ways[step - leaps[index]];
                }
            }
            if (slippery.contains(step)) {
                int last = step - 1;
                while (slippery.contains(last) && last > 0) {
                    last--;
                }
                if (last > 0) {
                    ways[last] += ways[step];
                }
                ways[step] = 0;
            }
        }
        System.out.print(ways[N]);

    }
}
