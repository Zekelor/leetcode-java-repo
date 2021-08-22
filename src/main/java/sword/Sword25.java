package sword;

import common.ListNode;

/**
 * @author fxzou
 * @date 2021/8/22
 * @since IntelliJ IDEA
 */
public class Sword25 {
    /**
     * 递归法
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoListsByRecur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecur(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergerTwoListByInter(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }

        if (l2 == null) {
            cur.next = l1;
        }

        return node.next;
    }
}
