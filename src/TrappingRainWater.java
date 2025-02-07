import java.util.*;
public class TrappingRainWater {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int left = 0, right = arr.length - 1;
        int leftMax = arr[left], rightMax = arr[right];

        int trapped = 0;
        while (left < right) {

            if (leftMax <= rightMax) {
                trapped += leftMax - arr[left];
                leftMax = Math.max(leftMax, arr[++left]);

            } else {
                trapped += rightMax - arr[right];
                rightMax = Math.max(rightMax, arr[--right]);

            }
        }

        System.out.print(trapped);


    }
}
