public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        if (height.length == 1)
            return 0;

        int sum=0;
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        int max=0;
        for (int i=0; i < height.length; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }

        max = 0;
        for (int i=height.length-1; i >= 0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }

        for (int i=0; i < height.length; i++) {
            sum += Math.min(left[i],right[i]) - height[i];
        }

        return sum;
    }
}
