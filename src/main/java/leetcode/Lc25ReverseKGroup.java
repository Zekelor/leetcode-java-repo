package leetcode;

import common.ListNode;

/**
 * @author fxzou
 * @date 2021/8/30
 * @since IntelliJ IDEA
 */
public class Lc25ReverseKGroup {

    /**
     * K个一组翻转
     *
     * @param node
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode node, int k) {
        ListNode dummy = new ListNode(0);

        dummy.next = node;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }
            // 记录要翻转的下一个节点
            ListNode next = end.next;
            // 断开链表
            end.next = null;

            // 记录要翻转的头节点
            ListNode start = pre.next;

            pre.next = reverse(start);

            start.next = next;

            pre = start;

            end = start;
        }

        return dummy.next;


    }


    public ListNode reverse(ListNode node) {

        ListNode pre = null, cur = node;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

    }
}
