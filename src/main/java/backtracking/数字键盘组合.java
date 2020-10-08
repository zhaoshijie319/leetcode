package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * <p>A mapping of digit to letters (just like on the telephone buttons) is given below. 1 2(abc)
 * 3(def) 4(ghi) 5(jkl) 6(mno) 7(pqrs) 8(tuv) 9(wxyz)
 *
 * <p>
 *
 * <p>Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you
 * want.
 */
public class 数字键盘组合 {
    private String[] NUMBER_ALPHA = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) throws Exception {
        List<String> result = new 数字键盘组合().letterCombinations("23");
        result.forEach(System.out::println);
    }

    private List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty() || digits.contains("1") || digits.contains("0"))
            return new ArrayList<>();
        List<String> prev = new ArrayList<>();
        prev.add("");
        for (int i = digits.length() - 1; i >= 0; i--) {
            String str = NUMBER_ALPHA[Integer.parseInt(String.valueOf(digits.charAt(i)))];
            List<String> newList = new ArrayList<>();
            for (int j = 0, l = str.length(); j < l; j++) {
                for (String s : prev) {
                    s = str.charAt(j) + s;
                    newList.add(s);
                }
            }
            prev = newList;
        }
        return prev;
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}
