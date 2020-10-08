package sortAlgorithm;

/**
 * 快速排序：交换、不稳定、O(nlog(n))
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5, 3, 9, 2, 7, 6, 8, 0};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static int[] sort(int[] array) {
        int left = 0;
        int right = array.length;
        partition(array, left, right);
        return array;
    }

    public static void partition(int[] array, int left, int right) {
        if (left < right) {
            int index = quick(array, left, right);
            partition(array, left, index);
            partition(array, index + 1, right);
        }
    }

    public static int quick(int[] array, int left, int right) {
        int index = left + 1;
        int cur = array[left];
        for (int i = index; i < right; i++) {
            if (array[i] < cur) {
                int temp = array[i];
                array[i] = array[index];
                array[index++] = temp;
            }
        }
        array[left] = array[index - 1];
        array[index - 1] = cur;
        return index - 1;
    }
}
