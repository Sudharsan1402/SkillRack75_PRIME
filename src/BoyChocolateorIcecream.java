import java.util.Scanner;
public class BoyChocolateorIcecream {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] choc = new int[N+1];
        int [] ice = new int[N+1];
        choc[1]=ice[1]=1;
        for(int day=2;day<=N;day++){
            choc[day] = choc[day-1]+ice[day-1];
            ice[day] = choc[day-1];
        }
        System.out.print(choc[N]+ice[N]);

    }
}
