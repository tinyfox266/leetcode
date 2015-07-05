public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new LinkedList<Integer>();
        if (nums == null || nums.length == 0)
            return majority;

        if (nums.length == 1) {
            majority.add(nums[0]);
            return majority;
        }

        int count1=0, count2=0;
        int n1=1, n2=1;
        for (int n: nums) {
            if (n == n1) {
                count1++;
            } else if (n == n2) {
                count2++;
            } else if (count1 == 0) {
                n1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                n2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n:nums) {
            if (n == n1)
                count1++;
            else if (n == n2)
                count2++;
        }

        if (count1 > nums.length/3)
            majority.add(n1);

        if (count2 > nums.length/3)
            majority.add(n2);

        return majority;

    }
}
