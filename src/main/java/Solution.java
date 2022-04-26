import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int length = 0;

        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> compareMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (compareMap.containsKey(character)) {
                left = Math.max(left, compareMap.get(character) + 1);
            }
            compareMap.put(character, i);

            length = Math.max(length, i - left + 1);
        }

        return length;

    }


    /**
     * 快速排序 [4,3,25,6,34,23]
     *
     * @param sourceArray
     * @return
     */
    public static int[] quickSort(int[] sourceArray) {

        return quickSortImplement(sourceArray, 0, sourceArray.length - 1);
    }

    /**
     * 快速排序的实现方法
     *
     * @param arr   数组
     * @param left  左边界 默认为0
     * @param right 右边界 length-1
     * @return
     */
    private static int[] quickSortImplement(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = getPartition(arr, left, right);
            quickSortImplement(arr, left, partitionIndex - 1);
            quickSortImplement(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 获取分区值
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int getPartition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int index = pivot + 1;

        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                //进行交换
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int pivot) {
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;
    }

    /**
     * 反转打印
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {

        ListNode pre = null;
        ListNode next = null;

        int count = 0;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }

        int[] size = new int[count];

        for (int i = 0; i < count; --i) {
            size[i] = head.val;
            head = head.next;
        }

        return size;
    }

    public static void main(String[] args) {
        System.out.println(judgeNumber(0.912));

        System.out.println(quickSort(new int[]{3, 2, 1, 5, 6, 4}));
    }

    /**
     * 低于0.1的print（1)，高于0.9的print（2），其他print（3）
     *
     * @param x
     * @return
     */
    public static int judgeNumber(double x) {
        return x < 0.1 ? 1 : x > 0.1 && x < 0.9 ? 2 : 3;
    }

    class ListNode {
        private int node;
        private int val;
        private ListNode next;

        public ListNode(int node) {
            this.node = node;
            this.next = next;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)



