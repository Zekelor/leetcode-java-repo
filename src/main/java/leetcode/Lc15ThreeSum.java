package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Lc15ThreeSum {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        // 如果数组为空或数组的元素个数小于三个则直接返回
        if (nums == null || length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            // 若当前的数字大于0 则结果肯定大于0 则中止循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 对左指针去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 对右指针去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    // 去重后指针需要进行移动
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSum(nums));

    }

}

