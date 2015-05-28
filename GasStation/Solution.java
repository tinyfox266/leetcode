public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return -1;
        if (gas.length != cost.length)
            return -1;

        int index=0;
        int sum=0;
        for (int i=0; i < gas.length; i++) {
            sum += gas[i]-cost[i];
            if (sum < 0) {
                index=i+1;
                sum=0;
            }
        }
        if (index == gas.length)
            return -1;
        for (int i=0; i < index; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0)
                return -1;
        }
        return index;
    }
}
