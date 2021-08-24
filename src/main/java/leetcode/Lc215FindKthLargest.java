package leetcode;

/**
 * @author fxzou
 * @date 2021/8/23
 * @since IntelliJ IDEA
 */
public class Lc215FindKthLargest {

    /**
     * 基于快速排序的解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        // 数组的长度
        int len = nums.length;
        // 左侧下标index 起始为0
        int left = 0;
        // 右侧下标index len-1
        int right = len - 1;

        // 目标的下标
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);

            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

    }

    /**
     * 返回快速排序中间值的下标位置
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums, int left, int right) {

        if (right > left) {
            int randomIdx = (int) (Math.random() * (right - left) + left);
            swap(nums, left, randomIdx);
        }

        // 初始化为第一个下标
        int pivot = nums[left];

        int cmpIndex = left;

        // cmpIndex 左侧的都比pivot小；右侧的都比pivot大
        for (int i = left + 1; i <= right; i++) {

            // 比游标的值小的都交换
            if (nums[i] < pivot) {
                cmpIndex++;
                swap(nums, cmpIndex, i);
            }
        }
        // 这一步是将pivot放到num[i]中
        swap(nums, left, cmpIndex);

        return cmpIndex;
    }

    /**
     * 将游标下标与右侧交换，param1 换到右边，param换到左边
     *
     * @param nums
     * @param compareIndex
     * @param cur
     */
    public static void swap(int[] nums, int compareIndex, int cur) {

        int temp = nums[compareIndex];
        nums[compareIndex] = nums[cur];
        nums[cur] = temp;
    }






}
