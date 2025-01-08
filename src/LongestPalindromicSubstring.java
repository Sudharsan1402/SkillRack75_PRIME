import java.util.*;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int N = str.length();
        int maxLen = 1;
        boolean[][] matrix = new boolean[N][N];
        for (int index = 0; index < N; index++) {
            matrix[index][index] = true;
        }
        for (int index = 0; index < N - 1; index++) {
            if (str.charAt(index) == str.charAt(index + 1)) {
                matrix[index][index + 1] = true;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= N; len++) {
            for (int index = 0; index < N - len + 1; index++) {
                if ((str.charAt(index) == str.charAt(index + len - 1)) && matrix[index + 1][index + len - 2]) {
                    matrix[index][index + len - 1] = true;
                    if (maxLen < len) {
                        maxLen = len;
                    }
                }
            }
        }
        System.out.print(maxLen);

    }
}
