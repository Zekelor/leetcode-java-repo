package sword;

import common.TreeNode;

/**
 * @author fxzou
 * @date 2021/8/20
 * @since IntelliJ IDEA
 */
public class Sword68Two {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 如果树为空直接返回，或者是p q为空的情况 此时root就是最近的祖先节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 开启递归左节点,若找到则返回
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 开启递归右节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        // 左右节点都为空的情况 说明p 和 q 都不在 返回
        if (left == null && right == null) {
            return null;
        }

        // 左节点为空 去右节点寻找，左侧就终止
        if (left == null) {
            return right;
        }

        // 右节点为空的话 就去左侧寻找，右侧就终止
        if (right == null) {
            return left;
        }

        // 最终返回的是左右节点都不为空的情况，p和q都在root的异侧
        return root;
    }
}
