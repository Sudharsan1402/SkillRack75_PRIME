import java.util.Scanner;
public class Maxsubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        int currSum = arr[0];
        int maxSum = arr[0];
        for(int i=1;i<N;i++){
            currSum = Math.max(currSum+arr[i], arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.print(maxSum);

    }
}
