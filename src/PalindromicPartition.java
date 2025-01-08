import java.util.*;
public class PalindromicPartition {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int N = str.length();
        boolean[][] palin = new boolean[N][N];

        for (int index = 0; index < N; index++) {
            palin[index][index] = true;
        }

        for (int index = 0; index < N - 1; index++) {
            if (str.charAt(index) == str.charAt(index + 1)) {
                palin[index][index + 1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int index = 0; index <= N - len; index++) {
                if (str.charAt(index) == str.charAt(index + len - 1) && palin[index + 1][index + len - 2]) {
                    palin[index][index + len - 1] = true;
                }
            }
        }

        Integer[][] splits = new Integer[N][N];

        System.out.println(calcSplits(str, 0, N - 1, palin, splits));

    }

    private static int calcSplits(String str, int start, int end, boolean[][] palin, Integer[][] splits) {
        if (palin[start][end]) {
            return 0;
        }

        if (splits[start][end] != null) {
            return splits[start][end];
        }

        int minSplits = str.length();
        for (int index = start; index < end; index++) {
            int currSplits = 1 + calcSplits(str, start, index, palin, splits) + calcSplits(str, index + 1, end, palin, splits);

            if (currSplits < minSplits) {
                minSplits = currSplits;
            }
        }

        splits[start][end] = minSplits;
        return minSplits;
    }
}
