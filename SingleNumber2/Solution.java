public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> one = new HashSet<Integer>();
        Set<Integer> two = new HashSet<Integer>();
        for (int num: nums) {
            if (!two.contains(num)) {
                one.add(num);
                two.add(num);
            } else {
                one.remove(num);
            }
        }
        return one.iterator().next();

    }
}
