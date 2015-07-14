public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int [][] intMatrix = new int[matrix.length][matrix[0].length];

        for (int j=0; j < matrix[0].length; j++) {
            intMatrix[0][j] = matrix[0][j]-'0';
        }

        for (int i=1; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                intMatrix[i][j] = (matrix[i][j]=='1' ? intMatrix[i-1][j]+1 : 0);
            }
        }

        int max=0;
        for (int i=0; i < intMatrix.length; i++) {
            max = Math.max(max, largestRectangleArea(intMatrix[i]));
        }

        return max;
    }

    int largestRectangleArea(int [] height) {
        Stack<Integer> stack = new Stack<Integer>();

        int max=0;

        for (int i=0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i])
                stack.push(i);
            else {
                int e = stack.pop();

                if (!stack.isEmpty()) {
                    max = Math.max(max, (i - stack.peek() - 1) * height[e]);
                } else {
                    max = Math.max(max, i*height[e]);
                }
                i--;
            }
        }

        while (! stack.isEmpty()) {
            int e = stack.pop();
            if (!stack.isEmpty()) {
                max = Math.max(max, (height.length - stack.peek() - 1) * height[e]);
            } else {
                max = Math.max(max, (height.length ) * height[e]);
            }
        }

        return max;
    }
}
