package bitManipulation;

public class 只出现一次的数字2 {

    public void FindNumsAppearOnce(int[] nums, int num1, int num2) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
    }
}
