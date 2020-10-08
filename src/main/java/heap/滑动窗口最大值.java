package heap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 *
 * <p>For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * <p>Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1
 * -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Therefore, return
 * the max sliding window as [3,3,5,5,6,7].
 *
 * <p>Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */
public class 滑动窗口最大值 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public int[] maxInWindows2(int[] nums, int k) {
        int[] result = new int[nums.length - (k - 1)];

        if (nums.length == 0) return new int[0];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0, l = nums.length; i < l; i++) {
            int head = i - (k - 1);
            if (head >= 0) {
                // remove out of range
                if (queue.peek() != null && queue.peek() < head) queue.poll();
            }
            while (queue.peekLast() != null && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) result[j++] = nums[queue.peek()];
        }

        return result;
    }
}
