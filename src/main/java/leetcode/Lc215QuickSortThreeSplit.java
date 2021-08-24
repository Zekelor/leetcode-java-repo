package leetcode;

/**
 * @author fxzou
 * @date 2021/8/24
 * @since IntelliJ IDEA
 */
public class Lc215QuickSortThreeSplit {


    public static void main(String[] args) {
        findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);


    }

    public static int findKthLargest(int[] nums, int k) {
        //进行快速排序
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    public static void quickSort(int[] nums, int l, int r) {

        int i = l;
        int j = r;
        if (l >= r) {
            return;
        }
        // 随机选一个值出来 作为参考值 这样时间复杂度才是NlogN级别的
        int k = (int) (Math.random() * (r - l + 1)) + l;
        //与第一个值交换
        switchNum(nums, l, k);
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= pivot) {
                r--;
            }
            while (l < r && nums[l] >= pivot) {
                l++;
            }
            switchNum(nums, l, r);
        }
        switchNum(nums, i, r);
        switchNum(nums, i, l - 1);
        switchNum(nums, l + 1, j);

    }

    public static void switchNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
