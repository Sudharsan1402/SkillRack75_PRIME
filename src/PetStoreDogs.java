import java.util.*;
import java.math.BigInteger;
public class PetStoreDogs {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        BigInteger ways [] = new BigInteger[N + 1];

        for (int ctr = 1; ctr <= N; ctr++) {
            if (ctr <= 2) {
                ways[ctr] = BigInteger.valueOf(ctr);
            } else {
                BigInteger passive = BigInteger.valueOf(ctr - 1).multiply(ways[ctr - 2]);
                ways[ctr] = passive.add(ways[ctr - 1]);
            }
        }

        System.out.print(ways[N].toString());

    }
}
