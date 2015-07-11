public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> elements = new HashMap<Character, Integer>();

        int max=0;
        int len=0;
        int pre=0;
        // invarint s[pre...i] does not contain repeated elements
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (elements.get(c) == null) {
                elements.put(c, i);
            } else {
                int pos = elements.get(c);
                if (pos >= pre) {
                    max = Math.max(max, i-pre);
                    pre = pos+1;
                }
                elements.put(c,i);
            }
        }
        max = Math.max(max, s.length()-pre);

        return max;
    }
}

