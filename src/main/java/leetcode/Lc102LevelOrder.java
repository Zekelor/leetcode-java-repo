package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fxzou
 * @date @{date}
 * @since jdk.18
 */
public class Lc102LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }

}
