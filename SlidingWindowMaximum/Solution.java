public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];

        Deque<Integer> q = new ArrayDeque<Integer>();

        int [] res = new int[nums.length-k+1];
        int start=0;
        int max=Integer.MIN_VALUE;
        for (int i=0; i < k; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.offer(i);
        }
        res[start++] = nums[q.peek()];

        for (int i=k; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i-k+1)
                q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            res[start++] = nums[q.peek()];
        }

        return res;

    }
}

