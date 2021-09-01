package leetcode;

/**
 * @author fxzou
 * @date 2021/9/1
 * @since IntelliJ IDEA
 */
public class Lc53MaxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxNum = nums[0];

        for (int x : nums) {
            pre = Math.max(pre + maxNum, maxNum);

            maxNum = Math.max(maxNum, pre);
        }

        return maxNum;
    }
}
