package string;

import org.junit.Assert;
import org.junit.Test;

public class 字符串中第一个唯一字符 {

    @Test
    public void test() {
        Assert.assertEquals(0, firstUniqChar("leetcode"));
        Assert.assertEquals(2, firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {

        char[] hash = new char[128];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
