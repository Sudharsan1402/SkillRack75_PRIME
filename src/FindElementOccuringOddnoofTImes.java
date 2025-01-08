import java.util.*;
public class FindElementOccuringOddnoofTImes {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int result = arr[0];
        for (int i = 1; i < N; i++) {
            result ^= arr[i];
        }

        System.out.print(result);

    }
}
