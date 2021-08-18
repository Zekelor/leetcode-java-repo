package sword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fxzou
 * @date 2021/8/18
 * @since IntelliJ IDEA
 */
public class Sword54 {

    /**
     * result定义全局
     */
    int result = 0;
    /**
     * 形参k不能随着迭代进行改变，因此引用全局的K值
     */
    int k = 0;

    public int kthLargestMethod1(TreeNode root, int k) {
        // 初始化变量k
        this.k = k;

        dfs1(root);

        return result;
    }

    public void dfs1(TreeNode root) {

        // root为null判断的是当前节点是否为空，k为0是特殊情况提前返回
        if (root == null || k == 0) {
            return;
        }

        dfs1(root.right);

        if (--k == 0) {
            result = root.val;
            return;
        }

        dfs1(root.left);
    }

    /**
     * 解法二
     */
    List<Integer> array = new ArrayList<>();

    public int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        return array.get(array.size() - k);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        array.add(node.val);

        dfs(node.right);
    }
}
