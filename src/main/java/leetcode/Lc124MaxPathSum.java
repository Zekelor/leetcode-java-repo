package leetcode;

import common.TreeNode;

/**
 * @author fxzou
 * @date 2021/8/19
 * @since IntelliJ IDEA
 */
public class Lc124MaxPathSum {

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        getMax(root);

        return ret;
    }

    public int getMax(TreeNode node) {
        // 若当前节点为叶子节点，那么返回0
        if (node == null) {
            return 0;
        }

        // dfs遍历左子树，若为空则剪裁掉
        int left = Math.max(0, getMax(node.left));

        // dfs遍历右子树
        int right = Math.max(0, getMax(node.right));


        // 更新最大值，当前遍历的最大值= 左+根+右 ，与全局的ret比较，取最大的
        ret = Math.max(ret, (left + right + node.val));

        // 计算当前节点的左右的最大值，必须添加当前节点的值在内
        return Math.max(left, right) + node.val;

    }

}
