import java.util.Scanner;
public class BoyIcecreamkthday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        long [] choc = new long[N+1];
        long [] ice = new long[N+1];
        choc[1]=ice[1]=1;
        for(int day=2;day<=N;day++){
            choc[day] = choc[day-1]+ice[day-1];
            if(day%K == 0){
                ice[day] = choc[day-1]+ice[day-1];
            }
            else{
                ice[day] = choc[day-1];
            }
        }
        System.out.print(choc[N]+ice[N]);

    }
}
