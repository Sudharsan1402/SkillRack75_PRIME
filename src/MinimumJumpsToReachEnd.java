import java.util.*;
public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int jumps = 1, maxReachIndex = arr[0], steps = arr[0];
        for (int index = 1; index < N; index++) {
            if (index == N - 1) {
                break;
            }
            if (index + arr[index] > maxReachIndex) {
                maxReachIndex = index + arr[index];
            }
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReachIndex - index;
            }
        }

        System.out.print(jumps);

    }
}
