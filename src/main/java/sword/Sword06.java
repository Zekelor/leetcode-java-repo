package sword;

import common.ListNode;

import java.util.Stack;

/**
 * @author fxzou
 * @date 2021/8/18
 * @since IntelliJ IDEA
 */
public class Sword06 {
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack =new Stack<>();

        while(head!=null){
            stack.add(head.val);
            head =head.next;
        }

        int n =stack.size();

        int[] result =new int[n];


        for(int i=0;i<n;i++){
            result[i] =stack.pop();
        }

        return result;
    }

}
