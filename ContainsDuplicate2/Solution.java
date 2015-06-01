public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; i++) {
            int v = nums[i];
           if (map.containsKey(v)) {
               int index = map.get(v);
               if (i-index <= k)
                   return true;
           }
            map.put(v,i);
        }
        return false;
    }
}
