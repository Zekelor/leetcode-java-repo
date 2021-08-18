package sword;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fxzou
 * @date 2021/8/17
 * @since IntelliJ IDEA
 */
public class Sword37 {

    /**
     * Encodes a tree to a single string.
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        StringBuilder s = new StringBuilder().append("[");

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {

                s.append(temp.val + ",");

                // 这个地方不需要加非空的判断，若空的话需要往左右子树增加空的节点 null
                queue.add(temp.left);
                queue.add(temp.right);

            } else {
                s.append("null,");
            }

        }

        String resultStr = s.deleteCharAt(s.length() - 1).toString();

        resultStr += "]";
        return resultStr;
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }

        String[] array = data.substring(1, data.length() - 1).split(",");


        TreeNode root = new TreeNode(Integer.parseInt(array[0]));

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        int i = 1;

        // 关于这边的数组越界问题，最好增加个i<array.length的判断
        while (!queue.isEmpty() && i < array.length) {
            TreeNode temp = queue.poll();

            if (!"null".equals(array[i])) {
                temp.left = new TreeNode(Integer.parseInt(array[i]));
                queue.add(temp.left);
            }

            i++;

            if (!"null".equals(array[i])) {
                temp.right = new TreeNode(Integer.parseInt(array[i]));
                queue.add(temp.right);
            }
            i++;
        }

        return root;

    }

    public static void main(String[] args) {
        System.out.println(deserialize("[1,2,3,null,null,4,5]"));
    }
}
