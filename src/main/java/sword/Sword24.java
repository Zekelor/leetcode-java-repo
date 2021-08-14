package sword;

import common.ListNode;

/**
 * @author fxzou
 * @date 2021/8/14
 * @since IntelliJ IDEA
 */
public class Sword24 {
    public ListNode revertListNode(ListNode head) {
        ListNode cur = head, pre = null;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }
}
