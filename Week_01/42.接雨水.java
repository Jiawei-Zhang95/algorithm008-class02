import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        /**
         * 暴力解法
         */
        // int sum = 0;
        // for (int i = 1; i < height.length - 1; i++) {
        // int maxLeft = 0;
        // for (int j = i - 1; j >= 0; j--) {
        // if (height[j] > maxLeft) {
        // maxLeft = height[j];
        // }
        // }

        // int maxRight = 0;
        // for (int j = i + 1; j < height.length; j++) {
        // if (height[j] > maxRight) {
        // maxRight = height[j];
        // }
        // }

        // int min = Math.min(maxLeft, maxRight);
        // if (min > height[i]) {
        // sum += min - height[i];
        // }
        // }

        // return sum;

        /**
         * 用栈
         */

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            // 如果栈不是空的而且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                System.out.println("当前扫描高度" + height[current]);
                System.out.println("栈的最前高度" + height[stack.peek()]);
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                int temp = distance * (min - h);
                System.out.println("新增高度" + temp);
                sum += distance * (min - h);
                System.out.println("当前sum: " + sum);
            }
            stack.push(current);
            System.out.println("pushed index:" + current);
            current++;
        }

        return sum;
    }
}
// @lc code=end
