package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of
 * integers (h, k), where h is the height of the person and k is the number of people in front of this
 * person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * <p>Note: The number of people is less than 1,100.
 *
 * <p>Example
 *
 * <p>Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * <p>Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class 按身高排序 {
    public static void main(String[] args) throws Exception {
        int[][] A = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] r = new 按身高排序().reconstructQueue(A);
        for (int[] i : r) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
