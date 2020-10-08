package sortAlgorithm;

/**
 * 冒泡排序：交换、稳定、O(n2)
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5, 3, 9, 2, 7, 6, 8, 0};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static int[] sort(int[] array) {
        int len = array.length;
        for (int i = len; i > 0; i--) {
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (array[j - 1] > array[j]) {
                    flag = false;
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }
}
