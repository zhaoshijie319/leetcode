package bitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 *
 * <p>Given two integers x and y, calculate the Hamming distance.
 *
 * <p>Note: 0 ≤ x, y < 231.
 *
 * <p>Example:
 *
 * <p>Input: x = 1, y = 4
 *
 * <p>Output: 2
 *
 * <p>Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 *
 * <p>The above arrows point to positions where the corresponding bits are different.
 *
 * <p>Solution O(1): XOR (x, y) and count the number of bits set
 */
public class 汉明距离1 {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            if ((z & 1) == 1) cnt++;
            z = z >> 1;
        }
        return cnt;
    }

    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }

    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
