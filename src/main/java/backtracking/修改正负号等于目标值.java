package backtracking;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have
 * 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * <p>Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * <p>Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 *
 * <p>-1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 *
 * <p>There are 5 ways to assign symbols to make the sum of nums be target 3. Note: The length of
 * the given array is positive and will not exceed 20. The sum of elements in the given array will
 * not exceed 1000. Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class 修改正负号等于目标值 {

    private static int n;

    public static void main(String[] args) throws Exception {
        int[] A = {1, 1, 1, 1, 1};
        n = 0;
        new 修改正负号等于目标值().findTargetSumWays(A, 3);
        System.out.println(n);
    }

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, S, 0, 0);
        return n;
    }

    private void backtrack(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (sum == target) {
                n++;
            }
        } else {
            backtrack(nums, target, sum + nums[i], i + 1);
            backtrack(nums, target, sum - nums[i], i + 1);
        }
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
