import java.util.*;
public class mobilesnotbacktoowners {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long current=0,prev2=1,prev1=0;
        if(n==0){
            System.out.println(1);
            return;
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        for(int i=2;i<=n;i++){
            current=(i-1)*(prev1+prev2);
            prev2=prev1;
            prev1=current;
        }
        System.out.println(current);
    }
}
