import java.util.*;
public class CharacterinNorNminusoneStringsCommon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] asciicount = new int[128];
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.next();
            int [] currcount = new int [128];
            for (int j = 0; j < arr[i].length(); j++) {
                char ch = arr[i].charAt(j);
                if (currcount[ch] == 0 && (asciicount[ch] == i || asciicount[ch] == i-1)) {
                    asciicount[ch]++;
                    currcount[ch]++;
                }
            }
        }

        for (int i = 0; i < 128; i++) {
            if (asciicount[i] == N || asciicount[i] == N-1) {
                System.out.print((char) i);
            }
        }



    }
}
