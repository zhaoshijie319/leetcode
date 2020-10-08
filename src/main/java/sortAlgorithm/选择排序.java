package sortAlgorithm;

/**
 * 选择排序：不稳定、O(n2)
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5, 3, 9, 2, 7, 6, 8, 0};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static int[] sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
