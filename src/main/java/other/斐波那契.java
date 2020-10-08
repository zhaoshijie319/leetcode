package other;

import java.util.Arrays;

/**
 * 矩形覆盖、跳台阶
 */
public class 斐波那契 {

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fib(n - 1);
    }

    public int fib_2(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = result * i;
        }
        return result;
    }

    public int rectCover(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public int jumpFloor1(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public int jumpFloor2(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
