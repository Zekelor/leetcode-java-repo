package leetcode;

import common.ListNode;

/**
 * @author fxzou
 * @date @{date}
 * @since jdk.18
 */
public class Lc141HasCycle {

    public boolean hasCycle(ListNode node) {

        if (node == null || node.next == null) {

            return false;
        }

        ListNode slow = node;
        ListNode fast = node.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        return true;
    }
}
