public class Solution {
    // 该版本由 left, right版本改进而来。
    // left,right版本即超时的那个版本，其遍历了三遍，而此版本在计算right的同时计算了left,
    // 故只遍历了一遍，
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();

        int max=0;

        for (int i=0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                while (!stack.isEmpty() && stack.peek() == top) {
                    stack.pop();
                }
                // left is start, 因为stack中的元素有性质
                // height[stack[i] + 1, ..., stack[i+1]] 均比 height[stack[i]]小，而 height[stack[i]] <= height[stack[i+1]]
                // 故有 height[stack[i] + 1, ..., stack[i+1]] 均比 height[stack[i+1]]小
                int start = stack.isEmpty()?0:stack.peek()+1;
                max = Math.max(max, (i-start) * height[top]);
                i--;

            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!stack.isEmpty() && stack.peek() == top) {
                stack.pop();
            }
            int start = stack.isEmpty()?0:stack.peek()+1;
            max = Math.max(max, (height.length-start) * height[top]);
        }

        return max;
    }
}

