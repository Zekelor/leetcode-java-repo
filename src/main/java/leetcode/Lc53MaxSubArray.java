package leetcode;

/**
 * @author fxzou
 * @date 2021/9/1
 * @since IntelliJ IDEA
 */
public class Lc53MaxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];

        for(int num :nums){
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
