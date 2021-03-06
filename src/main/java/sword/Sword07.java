package sword;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * @author fxzou
 */
public class Sword07 {
    int[] preorder;
    Map<Integer, Integer> markMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for (int i = 0; i < inorder.length; i++) {
            markMap.put(inorder[i], i);
        }
        //三个索引分别为
        //当前根的的索引
        //递归树的左边界，即数组左边界
        //递归树的右边界，即数组右边界
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * 生成二叉树
     *
     * @param pre_root
     * @param in_left
     * @param in_right
     * @return
     */
    TreeNode recur(int pre_root, int in_left, int in_right) {
        // 相等的话就是自己
        if (in_left > in_right) {
            return null;
        }
        // 获取root节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        // 获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        int idx = markMap.get(preorder[pre_root]);
        // 左子树的根的索引为先序中的根节点+1
        // 递归左子树的左边界为原来的中序in_left
        // 递归右子树的右边界为中序中的根节点索引-1
        root.left = recur(pre_root + 1, in_left, idx - 1);
        // 右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        // 递归右子树的左边界为中序中当前根节点+1
        // 递归右子树的有边界为中序中原来右子树的边界
        root.right = recur(pre_root + (idx - in_left) + 1, idx + 1, in_right);
        return root;
    }

}
