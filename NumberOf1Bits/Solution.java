public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        String nStr = Integer.toBinaryString(n);

        for (int i=0; i < nStr.length(); i++) {
            if(nStr.charAt(i) == '1')
                count++;
        }

        return count;
    }
}
