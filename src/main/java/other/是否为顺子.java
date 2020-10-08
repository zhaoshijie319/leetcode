package other;

import java.util.Arrays;

public class 是否为顺子 {
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }
}
