package common;

/**
 * 构建二叉树
 *
 * @author fxzou
 * @date 2021/8/10
 * @since IntelliJ IDEA
 */
public class TreeNode {

    public int val;

    public TreeNode root;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode root, TreeNode left, TreeNode right) {
        this.val = val;
        this.root = root;
        this.left = left;
        this.right = right;
    }
}
