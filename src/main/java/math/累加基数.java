package math;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * <p>For example:
 *
 * <p>Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return
 * it.
 *
 * <p>Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class 累加基数 {

    public static void main(String[] args) throws Exception {
        System.out.println(new 累加基数().addDigits(38));
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}
