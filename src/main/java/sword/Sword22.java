package sword;

import common.ListNode;

/**
 * @author fxzou
 * @date 2021/8/21
 * @since IntelliJ IDEA
 */
public class Sword22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;

        int step = 0;

        while (fast != null) {
            if (step >= k) {
                slow = slow.next;
            }

            fast = fast.next;
            step++;
        }

        return slow;

    }

}
