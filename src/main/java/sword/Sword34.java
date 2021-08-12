package sword;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fxzou
 * @date 2021/8/12
 * @since IntelliJ IDEA
 */
public class Sword34 {
    LinkedList<List<Integer>> result = new LinkedList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        recur(root, target);

        return result;
    }

    private void recur(TreeNode root, int target) {

        if (root == null) {
            return;
        }

        target -= root.val;

        path.add(root.val);

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList(path));
        }
        recur(root.left,target);

        recur(root.right,target);

        path.removeLast();

    }
}
