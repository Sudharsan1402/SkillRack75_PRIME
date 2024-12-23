import java.util.*;
public class CombinationofNumberswhichadduptoZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int counter = 0;

        for (int ctr = 1; ctr < (1 << N); ctr++) {
            int sum = 0;

            for (int index = 0; index < N; index++) {
                if ((ctr & (1 << index)) != 0) {
                    sum += arr[index];
                }
            }

            if (sum == 0) {
                counter++;
            }
        }

        System.out.print(counter);

    }
}
