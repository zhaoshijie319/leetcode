package sortAlgorithm;

/**
 * 基数排序：稳定、O(d(r + n))
 */
public class 基数排序 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5, 3, 9, 2, 7, 6, 8, 0};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static int[] sort(int[] array) {
        int[] bucket = new int[10];
        int len = array.length;
        for (int i = 0; i < len; i++) {
            bucket[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            while (bucket[i] > 0) {
                array[index++] = i;
                bucket[i]--;
            }
        }
        return array;
    }
}
