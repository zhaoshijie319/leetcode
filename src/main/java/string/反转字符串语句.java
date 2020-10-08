package string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an input string, reverse the string word by word.
 *
 * <p>For example, Given s = "the sky is blue", return "blue is sky the".
 *
 * <p>Clarification: What constitutes a word? A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces? Yes. However, your reversed string
 * should not contain leading or trailing spaces. How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class 反转字符串语句 {
    public static void main(String[] args) throws Exception {
        System.out.println(new 反转字符串语句().reverseWords("  the     sky is blue"));
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder(s.trim());
        String reverse = sb.reverse().toString();
        StringTokenizer st = new StringTokenizer(reverse, " ");
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        for (int i = 0, l = list.size(); i < l; i++) {
            String str = list.get(i);
            String newStr = new StringBuilder(str).reverse().toString();
            list.set(i, newStr);
        }
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str).append(" ");
        }
        return result.toString().trim();
    }

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
