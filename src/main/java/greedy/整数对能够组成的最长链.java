package greedy;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the
 * second number.
 *
 * <p>Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of
 * pairs can be formed in this fashion.
 *
 * <p>Given a set of pairs, find the length longest chain which can be formed. You needn't use up
 * all the given pairs. You can select pairs in any order.
 *
 * <p>Example 1: Input: [[1,2], [2,3], [3,4]] Output: 2 Explanation: The longest chain is [1,2] ->
 * [3,4] Note: The number of given pairs will be in the range [1, 1000].
 *
 * <p>Solution: O(N log N) sort the pairs with ending interval (greedy sort) and try to accommodate
 * as many pairs as possible. If any current pair violates the chaining condition (b < c) then,
 * ignore that particular pair.
 */
public class 整数对能够组成的最长链 {

    public static void main(String[] args) throws Exception {
        int[][] A = {{3, 4}, {2, 2}, {1, 2}};
        System.out.println(new 整数对能够组成的最长链().findLongestChain(A));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(
                pairs,
                (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int count = 1;
        int[] curr = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > curr[1]) {
                count++;
                curr = pairs[i];
            }
        }
        return count;
    }

    public int findLongestChain2(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
