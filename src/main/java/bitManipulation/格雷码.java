package bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * <p>Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 *
 * <p>For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * <p>00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not uniquely defined.
 *
 * <p>For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * <p>For now, the judge is able to judge based on one instance of gray code sequence. Sorry about
 * that.
 */
public class 格雷码 {

    public static void main(String[] args) throws Exception {
        List<Integer> result = new 格雷码().grayCode(3);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= ((1 << n) - 1); i++)
            result.add(i ^ (i >> 1));
        return result;
    }
}
