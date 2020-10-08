package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
 * if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume
 * the dictionary does not contain duplicate words.
 *
 * <p>For example, given s = "leetcode", dict = ["leet", "code"].
 *
 * <p>Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    public static void main(String[] args) throws Exception {
        List<String> dic = new ArrayList<>();
        String[] arr = {
                "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
        };
        for (String s : arr) dic.add(s);
        System.out.println(
                new WordBreak()
                        .wordBreak(
                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                dic));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {   // 对物品的迭代应该放在最里层
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
