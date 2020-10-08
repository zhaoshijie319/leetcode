package array;

/**
 * 题目:
 * 统计一个数字在排序数组中出现的次数.
 * 例如输入排序数组{1,2,3,3,3,3,4,5},由于3在这个数中出现了4次,输出4.
 */
public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = (h + l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }

}
