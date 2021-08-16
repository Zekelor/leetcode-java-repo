package sword;

import common.TreeNode;

/**
 * @author fxzou
 * @date 2021/8/16
 * @since IntelliJ IDEA
 */
public class Sword28 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left==null || right==null || left.val != right.val) {
            return false;
        }

        return recur(left.left, right.right) && recur(left.right, right.left);

    }
}
