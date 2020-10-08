package array;

public class 下一个更大的数2 {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1432));
    }

    public static int nextGreaterElement(int n) {
        char[] charArr = String.valueOf(n).toCharArray();
        //从后往前找到第一个开始减小的数
        int i = charArr.length - 2;
        while (i >= 0 && charArr[i] >= charArr[i + 1])
            i--;

        if (i < 0)  //整体递减
            return -1;

        //找到i之后刚好大于charArr[i]的值
        int j = charArr.length - 1;
        while (j >= i && charArr[j] <= charArr[i])
            j--;

        swap(charArr, i, j);
        reverse(charArr, i + 1, charArr.length - 1);

        try {
            return Integer.parseInt(new String(charArr));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void swap(char[] charArr, int i, int j) {
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }

    public static void reverse(char[] charArr, int begin, int end) {
        int i = begin, j = end;
        while (i < j) {
            swap(charArr, i, j);
            i++;
            j--;
        }
    }
}
