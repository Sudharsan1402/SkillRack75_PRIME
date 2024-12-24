import java.util.*;
public class PermutationsofnumberClosertoTarget {

    static int X;
    static int close;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.next();
        X = in.nextInt(); // Store X in the static variable

        int n = N.length();
        close = Integer.parseInt(N);

        permute(N.toCharArray(), 0, n - 1);
        System.out.println(close);

    }

    private static void permute(char[] N, int left, int right) {
        if (left == right) {
            int curr = Integer.parseInt(String.valueOf(N));
            close = Math.abs(X - curr) < Math.abs(X - close) ? curr : close;
            return;
        }

        for (int index = left; index <= right; index++) {
            swap(N, left, index);
            permute(N, left + 1, right);
            swap(N, left, index);
        }
    }

    private static void swap(char[] N, int x, int y) {
        char temp = N[x];
        N[x] = N[y];
        N[y] = temp;
    }

}
