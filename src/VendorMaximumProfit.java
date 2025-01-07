import java.util.*;
class Item implements Comparable<Item> {
    int costPrice, profit;

    @Override
    public int compareTo(Item other) {
        return this.costPrice - other.costPrice;
    }
}
public class VendorMaximumProfit {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        List<Item> items = new ArrayList<>();

        items.add(new Item()); // Add a dummy item at index 0

        for (int ctr = 1; ctr <= K; ctr++) {
            Item item = new Item();
            item.costPrice = in.nextInt();
            item.profit = in.nextInt();
            items.add(item);
        }

        Collections.sort(items);

        int[][] matrix = new int[K + 1][N + 1];

        for (int item = 1; item <= K; item++) {
            Item currItem = items.get(item);

            if (currItem.costPrice > N) {
                System.out.println(matrix[item - 1][N]);
                return;
            }

            for (int amt = 1; amt <= N; amt++) {
                matrix[item][amt] = matrix[item - 1][amt];

                if (amt >= currItem.costPrice) {
                    int incProfit = currItem.profit + matrix[item - 1][amt - currItem.costPrice];
                    int excProfit = matrix[item][amt];
                    matrix[item][amt] = Math.max(incProfit, excProfit);
                }
            }
        }

        System.out.println(matrix[K][N]);
    }
}
