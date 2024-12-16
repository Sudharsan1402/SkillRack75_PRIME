import java.util.Scanner;
import java.util.Stack;

public class ArrayNextGreaterElement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int greater;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() > arr[i]) {
                greater = stack.peek();
                stack.push(arr[i]);
                arr[i] = greater;
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                } else {
                    greater = stack.peek();
                    stack.push(arr[i]);
                    arr[i] = greater;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}