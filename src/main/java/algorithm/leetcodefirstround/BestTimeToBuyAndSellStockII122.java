package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/28/2019 12:16
 * @description:
 */
public class BestTimeToBuyAndSellStockII122 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                total += prices[i] - prices[i-1];
        }
        return total;
    }
}
