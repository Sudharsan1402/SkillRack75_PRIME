import java.util.*;
public class MinimumOperationsfrom0toN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N == 1 || N == 2){
            System.out.print(N);
            return;
        }
        int count = 2;
        while(N != 2){
            if(N%2 != 0){
                N -= 1;
            }else{
                N /= 2;
            }
            count++;
        }
        System.out.print(count);
    }
}
