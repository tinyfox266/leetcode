public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0)
            return false;
        Set elements = new HashSet();
        for (int i=0; i < nums.length; i++) {
            if (elements.contains(nums[i]))
                return true;
            elements.add(nums[i]);
        }
        return false;
    }
}
