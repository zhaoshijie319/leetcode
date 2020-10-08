package array;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 题目:
 * 输入n个整数,找出其中最小的K个数.
 * 例如输入,2,7,3,8,4,5,1,6这8个数字,则最小的是1,2,3,4
 */
public class 最小的K个数 {

    public static void main(String[] args) {
        int[] a = {3, 7, 6, 5, 4, 8, 2, 2, 6, 2, 2, 2, 1};

        TreeMap<Integer, Integer> tree = new TreeMap<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < a.length; i++) {
            tree.put(i, a[i]);
            if (tree.size() > 4) {
                tree.pollFirstEntry();
            }
        }
        System.out.println(tree);
    }

    public ArrayList<Integer> GetLeastNumbers(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] nums, int l, int h) {
        int p = nums[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
