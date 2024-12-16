import java.util.*;
public class SubarraySum {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int N = in.nextInt();
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = in.nextInt();
                }
                int s = in.nextInt();

                int currSum = arr[0];
                for (int li = 0, ri = 0; li < N && ri < N;) {
                    if (s == currSum) {
                        System.out.print("Yes");
                        return;
                    } else if (currSum < s) {
                        ri++;
                        if (ri < N) {
                            currSum += arr[ri];
                        }
                    } else {
                        currSum -= arr[li];
                        li++;
                    }
                }
                System.out.print("No");

    }
}
