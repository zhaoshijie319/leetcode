package dynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible
 * combinations that add up to a positive integer target.
 *
 * <p>Example:
 *
 * <p>nums = [1, 2, 3] target = 4
 *
 * <p>The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2)
 * (3, 1)
 *
 * <p>Note that different sequences are counted as different combinations.
 *
 * <p>Therefore the output is 7. Follow up: What if negative numbers are allowed in the given array?
 * How does it change the problem? What limitation we need to add to the question to allow negative
 * numbers?
 *
 * <p>Solution: Backtrack and dp
 */
public class 组合总和 {

    public static void main(String[] args) throws Exception {
        int[] A = {1, 2, 3};
        System.out.println(new 组合总和().combinationSum(A, 4));
    }

    public int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return backtrack(nums, dp, target);
    }

    private int backtrack(int[] nums, int[] dp, int sum) {
        int total = 0;
        if (sum < 0) return 0;
        if (dp[sum] != -1) return dp[sum];
        else {
            for (int num : nums) {
                total += backtrack(nums, dp, sum - num);
            }
        }
        dp[sum] = total;
        return dp[sum];
    }

    public int combinationSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maximum = new int[target + 1];
        maximum[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                maximum[i] += maximum[i - nums[j]];
            }
        }
        return maximum[target];
    }
}
