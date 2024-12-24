import java.util.*;
public class PermutationsofStringCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        permute(s.toCharArray(), 0, n - 1);
    }

    private static void permute(char[] s, int left, int right) {
        if (left == right) {
            System.out.println(String.valueOf(s));
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(s, left, i);
            permute(s, left + 1, right);
            swap(s, left, i);
        }
    }

    private static void swap(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;

    }
}
