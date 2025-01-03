
import java.util.*;
public class StockBuyandSellOnce {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int minPrice = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > minPrice) {
                maxProfit = Math.max(maxProfit, arr[i] - minPrice);
            } else {
                minPrice = arr[i];
            }
        }
        System.out.print(maxProfit);

    }
}
