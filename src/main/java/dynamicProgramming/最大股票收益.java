package dynamicProgramming;

public class 最大股票收益 {

    public static void main(String[] args) throws Exception {
        int[] prices = {1, 2, 3, 1, 5};
        System.out.println(new 最大股票收益().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] max = new int[len];
        max[len - 1] = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i + 1]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, max[i] - prices[i]);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int result = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(prices[i], buy);
            result = Math.max(result, prices[i] - buy);
        }

        return result;
    }
}
