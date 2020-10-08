package dynamicProgramming;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * <p>For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing subsequence is [2, 3,
 * 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is
 * only necessary for you to return the length.
 *
 * <p>Your algorithm should run in O(n2) complexity.
 *
 * <p>Follow up: Could you improve it to O(n log n) time complexity?
 */
public class 最长递增子序列 {

    public static void main(String[] args) throws Exception {
        int[] nums = {9, 8, 7, 6};
        System.out.println(new 最长递增子序列().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] A = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0, l = nums.length; i < l; i++) {
            int lis = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) lis = Math.max(lis, A[j] + 1);
            }
            A[i] = lis;
            max = Math.max(max, A[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
