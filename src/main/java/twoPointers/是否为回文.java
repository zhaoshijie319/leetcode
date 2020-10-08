package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class 是否为回文 {
    @Test
    public void test() {

        Assert.assertEquals(true, isPalindrome(""));
        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(true, isPalindrome("1A man, a plan, a canal: Panama1"));
        Assert.assertEquals(false, isPalindrome("race a car"));
        Assert.assertEquals(false, isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex && startIndex < s.length() - 1) {
            char pre = s.charAt(startIndex);
            char aft = s.charAt(endIndex);
            if (!((pre >= 'a' && pre <= 'z') || (pre >= '0' && pre <= '9'))) {
                startIndex++;
                continue;
            }
            if (!((aft >= 'a' && aft <= 'z') || (aft >= '0' && aft <= '9'))) {
                endIndex--;
                continue;
            }

            if (pre != aft) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
