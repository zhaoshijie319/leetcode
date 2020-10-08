package binarySearch;

/**
 * Implement int sqrt(int x).
 *
 * <p>Compute and return the square root of x.
 */
public class 求开方 {
    public static void main(String[] args) throws Exception {
        System.out.println(new 求开方().mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        int s = 0, e = x;
        long ans = 0L;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long prod = m * m;
            if (prod <= x) {
                s = (int) (m + 1);
                ans = m;
            } else e = (int) m - 1;
        }
        return (int) ans;
    }
}
