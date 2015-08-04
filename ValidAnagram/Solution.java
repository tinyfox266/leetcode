public class Solution {
    public boolean isAnagram(String s, String t) {
        if (t == null && s == null)
            return true;
            
        if (t == null || s == null)
            return false;
            
        if (s.length() != t.length())  
            return false;
            
        int [] letters = new int[26];
        
        
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c-'a']++;
        }
        
        for (int i=0; i < t.length(); i++) {
            char c = t.charAt(i);
            letters[c-'a']--;
            if (letters[c-'a'] < 0)
                return false;
        }
        
        return true;
    }
}
