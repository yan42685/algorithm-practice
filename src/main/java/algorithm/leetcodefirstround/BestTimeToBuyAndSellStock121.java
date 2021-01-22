package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/28/2019 10:51
 * @description:
 */
public class BestTimeToBuyAndSellStock121 {
    /**
     * 暴力算法
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int profit;
        for (int i = 0; i < prices.length; i++)
            for (int j = i; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                max = Math.max(profit, max);
            }
        return max;
    }

    /**
     * dp版本
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int possibleMax = 0;
        for (int i = 1; i < prices.length; i++) {
            possibleMax = Math.max(0, possibleMax += prices[i] - prices[i-1]);
            max = Math.max(max, possibleMax);
        }
        return max;
    }
}
