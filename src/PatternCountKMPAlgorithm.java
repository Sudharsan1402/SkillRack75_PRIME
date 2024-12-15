import java.util.Scanner;
public class PatternCountKMPAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        int n = s.length();
        int m = p.length();
        int[] lps = new int[m];
        int len = 0;
        lps[0] = 0;
        for (int i = 1; i < m; ) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i] = len+1;
                i++;
                len++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        int count = 0;
        for (int si = 0, ki = 0; si < n; ) {
            if (s.charAt(si) == p.charAt(ki)) {
                si++;
                ki++;
                if (ki == m) {
                    count++;
                    ki = 0;
                }
            } else {
                if (ki == 0) {
                    si++;
                } else {
                    ki = lps[ki - 1];
                }
            }
        }
        System.out.printf("Count=%d", count);
    }
}