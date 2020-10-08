package array;
/**
 * 题目：
 * 请实现一个函数，把数组中的每个空格替换成%20，例如：输入bie zhi hua，则输出bie%20zhi%20hua
 */
public class 替换空格 {

    public static void main(String[] args) {
        char[] str = {'b', 'i', 'e', ' ', 'z', 'h', 'i', ' ', 'h', 'u', 'a'};

        char[] newStr = replaceBlack(str);

        System.out.println(newStr);
    }

    private static char[] replaceBlack(char[] str) {
        int blackCount = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                blackCount++;
            }
        }

        int originLength = str.length;
        int newLength = str.length + blackCount * 2;

        char[] newStr = new char[newLength];

        int indexOrigin = originLength - 1;
        int indexNew = newLength - 1;

        while (indexOrigin >= 0 && indexNew >= 0) {
            if (str[indexOrigin] == ' ') {
                newStr[indexNew--] = '0';
                newStr[indexNew--] = '2';
                newStr[indexNew--] = '%';
            } else {
                newStr[indexNew--] = str[indexOrigin];
            }
            indexOrigin--;
        }
        return newStr;
    }

    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

}
