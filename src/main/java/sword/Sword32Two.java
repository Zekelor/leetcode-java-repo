package sword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fxzou
 * @date 2021/8/11
 * @since IntelliJ IDEA
 */
public class Sword32Two {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();


        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        while (!queue.isEmpty()) {

            List<Integer> array = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                array.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(array);
        }

        return resultList;

    }
}
