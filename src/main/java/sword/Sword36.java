package sword;

import common.Node;

/**
 * @author fxzou
 * @date 2021/8/12
 * @since IntelliJ IDEA
 */
public class Sword36 {
    Node pre, head;

    public Node treeToDoublyList(Node node) {
        if (node == null) {
            return null;
        }

        recur(node);

        head.left = pre;
        pre.right = head;
        return head;
    }

    public void recur(Node node) {
        if (node == null) {
            return;
        }
        recur(node.left);

        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;

        pre = node;
        recur(node.right);
    }
}
