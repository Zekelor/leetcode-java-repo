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

        while (current <= height.length) {

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
}
