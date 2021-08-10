package sword;

import common.TreeNode;

/**
 * @author fxzou
 * @date 2021/8/10
 * @since IntelliJ IDEA
 */
public class Sword27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
