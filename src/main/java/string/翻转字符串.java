package string;

import org.junit.Assert;
import org.junit.Test;

public class 翻转字符串 {


    @Test
    public void test1() {
        Assert.assertEquals("olleh", reverseString1("hello"));
        Assert.assertEquals("auhihzeib", reverseString1("biezhihua"));

    }

    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public String reverseString1(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }

        return new String(chars);
    }
}
