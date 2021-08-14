package sword;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fxzou
 * @date 2021/8/14
 * @since IntelliJ IDEA
 */
public class Sword55 {

    /**
     * 深度优先遍历
     *
     * @param node
     * @return
     */
    public int maxDepthByDFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = maxDepthByBFS(node.left);

        int maxRight = maxDepthByBFS(node.right);

        return Math.max(maxLeft, maxRight) + 1;

    }

    /**
     * 广度优先BFS遍历
     *
     * @param node
     * @return
     */
    public int maxDepthByBFS(TreeNode node) {

        if (node == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(node);
        }};
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;

            // 注意这边for循环时不能直接初始化queue.size(),否则queue的值一直在变化
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode root = queue.poll();

                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }

        return depth;
    }
}
