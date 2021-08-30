package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fxzou
 * @date 2021/8/30
 * @since IntelliJ IDEA
 */
public class L1TwoSum {

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{0, 0};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {

                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);

        }

        return null;

    }
}

