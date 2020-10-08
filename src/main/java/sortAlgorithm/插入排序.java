package sortAlgorithm;

/**
 * 插入排序：稳定、O(n2)
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5, 3, 9, 2, 7, 6, 8, 0};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static int[] sort(int[] array) {
        int len = array.length;
        int index;
        int cur;
        for (int i = 1; i < len; i++) {
            index = i - 1;
            cur = array[i];
            while (index >= 0 && array[index] > cur) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = cur;
        }
        return array;
    }
}
