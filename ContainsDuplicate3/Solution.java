public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k<=0)
            return false;


        TreeSet window = new TreeSet();
        for (int i=0; i < nums.length; i++) {
            if (i-k-1>=0)
                window.remove(nums[i-k-1]);
            Integer ceiling = (Integer)window.ceiling(nums[i]-t);
            Integer floor = (Integer) window.floor(nums[i]+t);
            if (ceiling != null && ceiling-t <= nums[i] ||
                floor != null && floor >= nums[i]-t) {
                return true;
            }
            window.add(nums[i]);

        }

        return false;
    }
}
