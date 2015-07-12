public class Solution {
    // �ð汾�� left, right�汾�Ľ�������
    // left,right�汾����ʱ���Ǹ��汾������������飬���˰汾�ڼ���right��ͬʱ������left,
    // ��ֻ������һ�飬
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
                // left is start, ��Ϊstack�е�Ԫ��������
                // height[stack[i] + 1, ..., stack[i+1]] ���� height[stack[i]]С���� height[stack[i]] <= height[stack[i+1]]
                // ���� height[stack[i] + 1, ..., stack[i+1]] ���� height[stack[i+1]]С
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

