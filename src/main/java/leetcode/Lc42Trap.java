package leetcode;

import java.util.Stack;

/**
 * @author fxzou
 * @date 2021/9/5
 * @since IntelliJ IDEA
 */
public class Lc42Trap {

    public int trap(int[] height) {
        int count = 0;

        Stack<Integer> stack = new Stack<>();

        int current = 0;

        while (current < height.length) {

            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];

                stack.pop();

                if (stack.empty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;

                int min = Math.min(height[stack.peek()], height[current]);

                count += distance * (min - h);

            }

            stack.push(current);
            current++;
        }
        return count;
    }

    public int trap2(int[] height) {
        int count = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            // 如果栈不为空并且当前索引高度大于栈顶则一直循环
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 栈顶的小元素出栈
                int curr = stack.peek();

                stack.pop();

                // 如果栈空了直接返回
                if (stack.isEmpty()) {
                    break;
                }
                // 栈顶的索引值就是前面的墙高度
                int left = stack.peek();
                // 当前的墙高度
                int right = i;
                //
                int h = Math.min(height[left], height[right]) - height[curr];

                count += (right - left - 1) * h;
            }

            stack.push(i);
        }

        return count;


    }
}
