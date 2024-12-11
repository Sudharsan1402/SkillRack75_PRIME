import java.util.Scanner;
public class Minsubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        int currSum = arr[0];
        int minSum = arr[0];
        for(int i=1;i<N;i++){
            currSum = Math.min(currSum+arr[i], arr[i]);
            minSum = Math.min(currSum, minSum);
        }
        System.out.print(minSum);

    }
}
