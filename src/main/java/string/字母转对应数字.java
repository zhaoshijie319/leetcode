package string;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * <p>For example:
 *
 * <p>A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */
public class 字母转对应数字 {
    String CONST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws Exception {
        System.out.println(new 字母转对应数字().titleToNumber("AAB"));
    }

    public int titleToNumber(String s) {
        int total = 0;
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int pos = CONST.indexOf(c) + 1;
            int pow = (int) Math.pow(26, j++);
            total += (pow * pos);
        }
        return total;
    }
}
