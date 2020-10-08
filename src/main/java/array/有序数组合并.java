package array;

import java.util.Arrays;

public class 有序数组合并 {

    // 先依次比较两个数组，按照小的就传入新的数组。当这次比较完之后可能有一个数组的长度很长，留下一些数组，然后在新数组的末尾插入即可。

    public static int[] mergeArray_1(int a[], int b[]) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void mergeArray_2(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }

        while (n >= 0) {
            nums1[n] = nums2[n];
            n--;
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 5, 7, 8, 10};
        int b[] = {1, 5, 7, 8};
        int[] ints = mergeArray_1(a, b);
        System.out.println(Arrays.toString(ints));
    }
}
