import java.util.*;
public class Robotclimbingstaircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int[] leaps = new int[S];

        for (int i = 0; i < S; i++) {
            leaps[i] = in.nextInt();
        }

        long[] ways = new long[N + 1];
        ways[0] = 1;

        for (int step = 0; step <= N; step++) {
            for (int index = 0; index < S; index++) {
                if (step >= leaps[index]) {
                    ways[step] += ways[step - leaps[index]];
                }
            }
        }

        System.out.print(ways[N]);

    }
}
