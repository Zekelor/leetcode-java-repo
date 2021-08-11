package sword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fxzou
 * @date 2021/8/10
 * @since IntelliJ IDEA
 */
public class Sword32One {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // 初始化队列 内部类中将root赋值
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        // 创建存放队列弹出的节点
        ArrayList<Integer> arrayList = new ArrayList<>();

        // BFS循环
        while (!queue.isEmpty()) {
            // 队首元素出列
            TreeNode node = queue.poll();
            // 将node.val添加至打印的数组中
            arrayList.add(node.val);

            // 添加左右子节点
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] result = new int[arrayList.size()];

        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                result[i] = arrayList.get(i);
            }
            return result;
        }

        return new int[0];

    }
}
