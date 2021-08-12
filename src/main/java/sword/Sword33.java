package sword;

import java.util.Stack;

/**
 * @author fxzou
 * @date 2021/8/11
 * @since IntelliJ IDEA
 */
public class Sword33 {
    /**
     * 辅助栈的方式进行先序遍历的镜像
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public static boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();

        int root = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--) {

            if (postorder[i] > root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
                stack.add(postorder[i]);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
        System.out.println(verifyPostorder2(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }

}
