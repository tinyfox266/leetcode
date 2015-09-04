public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        
        if (citations.length == 0)
            return 0;
            
        Arrays.sort(citations);
        
        int max = citations[citations.length-1];
        if (max <= 0)
            return 0;
        
        for (int i=citations.length-1; i >= 0; i--) {
            int count = citations.length-i;
            int n = citations[i];
            if (count == n) {
                return n;
            } else if (count > n) {
                return count-1;
            }
        }
        
        return citations.length;
        
        
    }
}
