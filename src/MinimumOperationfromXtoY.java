import java.util.*;
public class MinimumOperationfromXtoY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int count = 0;
        while(Y>X){
            if(Y%2 != 0){
                Y += 1;
            }else{
                Y /= 2;
            }
            count++;
        }
        count+=(X-Y);
        System.out.print(count);


    }
}
