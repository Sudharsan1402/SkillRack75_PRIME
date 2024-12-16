import java.util.*;

public class CancellingAdjacentArrayElements {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() == arr[i]) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        if (stack.size() == 0) {
            System.out.print("-1");
        } else {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}
