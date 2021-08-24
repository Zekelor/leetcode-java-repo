package leetcode;

import com.sun.deploy.util.StringUtils;

/**
 * @author fxzou
 * @date 2021/8/23
 * @since IntelliJ IDEA
 */
public class Lc215QuickSort {

    public static void main(String[] args) {
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));;
    }

    public static int findKthLargest2(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);


        return nums[nums.length - k];
    }


    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        // 选取切分的key
        int k = (int) (Math.random() * (right - left + 1)) + left;

        swap(nums, left, k);

        int pivot = nums[left];

        int low = left;

        int high = right;

        while (low < high) {

            while (low < high && nums[high] >= pivot) {
                high--;
            }


            while (low < high && nums[low] <= pivot) {
                low++;
            }

            swap(nums, low, high);
        }

        swap(nums, left, high);

        quickSort(nums, left, low - 1);

        quickSort(nums, low + 1, right);

    }


    /**
     * 交换left right位置
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void swap(int[] nums, int left, int right) {

        int temp = nums[left];

        nums[left] = nums[right];
        nums[right] = temp;

    }
}
