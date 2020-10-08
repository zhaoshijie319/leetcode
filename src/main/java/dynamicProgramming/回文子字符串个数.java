package dynamicProgramming;

/**
 * <p>Given a string, your task is to count how many palindromic substrings in this string.
 *
 * <p>The substrings with different start indexes or end indexes are counted as different substrings
 * even they consist of same characters.
 *
 * <p>Example 1: Input: "abc" Output: 3 Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2: Input: "aaa" Output: 6 Explanation: Six palindromic strings: "a", "a", "a", "aa",
 * "aa", "aaa". Note: The input string length won't exceed 1000.
 *
 * <p>Solution O(n ^ 2): Example abcba: Compare char at two indices each time for example if char at
 * index 0 and index 4 are equal and if substring 1 and 3 is a palindrome then, sub-string 0 and 4
 * is also a palindrome
 */
public class 回文子字符串个数 {

    public static void main(String[] args) {
        System.out.println(new 回文子字符串个数().countSubstrings("aaa"));
    }

    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
