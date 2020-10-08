package dynamicProgramming;

public class 爬楼梯 {


    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    public int climbStairs2(int n) {
        if (n == 0 || n == 1) return 1;
        int[] A = new int[n + 1];
        A[n] = 1;
        A[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) A[i] = A[i + 1] + A[i + 2];
        return A[0];
    }

}
