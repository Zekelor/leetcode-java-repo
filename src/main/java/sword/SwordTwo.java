package sword;

import common.TreeNode;

/**
 * @author fxzou
 * @date 2021/8/16
 * @since IntelliJ IDEA
 */
public class SwordTwo {

    public boolean isBalance(TreeNode root){

        if(root==null){
            return true;
        }

        return recur(root) != -1;
    }

    private int recur(TreeNode node){
        if(node ==null){
            return 0;
        }
        int left = recur(node.left);

        if(left==-1){
            return -1;
        }
        int right = recur(node.right);
        if(right==-1){
            return -1;
        }

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
