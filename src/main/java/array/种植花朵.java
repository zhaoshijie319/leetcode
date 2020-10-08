package array;

/**
 * <p>Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both
 * would die.
 *
 * <p>Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means
 * not empty), and a number n, return if n new flowers can be planted in it without violating the
 * no-adjacent-flowers rule.
 *
 * <p>Example 1: Input: flowerbed = [1,0,0,0,1], n = 1 Output: True Example 2: Input: flowerbed =
 * [1,0,0,0,1], n = 2 Output: False Note: The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000]. n is a non-negative integer which won't
 * exceed the input array size.
 */
public class 种植花朵 {

    public static void main(String[] args) throws Exception {
        int[] n = {1, 0, 0, 0, 1};
        System.out.println(new 种植花朵().canPlaceFlowers(n, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
