package twoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * <p>Examples:
 *
 * <p>Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * <p>Given "bbbbb", the answer is "b", with the length of 1.
 *
 * <p>Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 */
public class 最长非重复字串 {
    Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println(
                new 最长非重复字串()
                        .lengthOfLongestSubstring("asdfsdfsdfsdfasdfdjdjjdjjdjjjjjajsdjjdjdjjd"));
    }

    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, max = Integer.MIN_VALUE;
        for (int j = 0, l = s.length(); j < l; j++) {
            if (map.keySet().contains(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, (j - i) + 1);
        }
        return max;
    }
}
