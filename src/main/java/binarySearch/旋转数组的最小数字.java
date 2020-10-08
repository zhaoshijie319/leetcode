package binarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * <p>(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * <p>Find the minimum element.
 *
 * <p>You may assume no duplicate exists in the array.
 */
public class 旋转数组的最小数字 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
