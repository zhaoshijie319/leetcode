package dynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * <p>Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * <p>Note: You may not engage in multiple transactions at the same time (ie, you must sell the
 * stock before you buy again).
 *
 * <p>Solution: O(n): In the first iteration calculate the max profit that can be made by one buy
 * and sell by iterating from right to left and saving this in a dp array and maintaining a max
 * value. In the second iteration starting from left to right maintain a min value and calculate the
 * max profit that can be made by one buy and sell by taking the difference of current with min and
 * calculate the total profit of two transactions by summing up the current profit made with the
 * profit in dp array.
 */
public class 最大股票收益2 {

    public static void main(String[] args) throws Exception {
        int[] A = {10, 9, 8, 11, 7, 11};
        System.out.println(new 最大股票收益2().maxProfit(A));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;
        int[] dp = new int[len];
        int min = prices[0];
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = Math.max(max - prices[i], dp[i + 1]);
            max = Math.max(max, prices[i]);
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, prices[i] - min + dp[i]);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
