import java.util.*;
public class MaximumRevenuefromWineBottles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        int[][] max = new int[N][N];

        System.out.println(maxRevenue(prices, max, 0, N - 1, 1));

    }

    private static int maxRevenue(int[] prices, int[][] max, int left, int right, int year) {
        if (max[left][right] != 0) {
            return max[left][right];
        }

        if (left == right) {
            return prices[right] * year;
        }

        int leftRevenue = prices[left] * year + maxRevenue(prices, max, left + 1, right, year + 1);
        int rightRevenue = prices[right] * year + maxRevenue(prices, max, left, right - 1, year + 1);

        max[left][right] = Math.max(leftRevenue, rightRevenue);

        return max[left][right];
    }
}
