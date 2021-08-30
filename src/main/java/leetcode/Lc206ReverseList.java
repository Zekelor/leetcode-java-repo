package leetcode;

import common.ListNode;

/**
 * @author fxzou
 * @date 2021/8/30
 * @since IntelliJ IDEA
 */
public class Lc206ReverseList {

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
