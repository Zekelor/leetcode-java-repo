package algorithm.sorting.QuickSort;

import java.util.Arrays;

/**
 * @author :fxzou
 * @program :leetcode-java-repo
 * @description :快速排序模板
 * @create 2021-08-25 20:28
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] input = new int[]{4, 2, 5, 6, 1, 3};

        System.out.println(Arrays.toString(input));

        quickSort(input);

        System.out.println(Arrays.toString(input));

    }


    /**
     * 快速排序方法体
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        int length = nums.length == 0 || nums == null ? 0 : nums.length;

        quickSort(nums, 0, length - 1);

    }

    public static void quickSort(int[] nums, int left, int right) {

        // 若左侧数字大于右侧数字 则直接返回
        if (left > right) {
            return;
        }

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
     * 交换 i j下表的数字
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }

}
