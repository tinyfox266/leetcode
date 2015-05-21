public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isMonoIsomorphic(s,t) && isMonoIsomorphic(t,s);
    }

    public boolean isMonoIsomorphic(String s, String t) {
        Map codeMap = new HashMap();
        if (s.length() != t.length())
            return false;
        for (int i=0; i < s.length(); i++) {
            Character si = s.charAt(i);
            Character ti = t.charAt(i);
            if (codeMap.get(si) == null)
                codeMap.put(si, ti);
            else {
                if (codeMap.get(si) != ti)
                    return false;
            }
        }

        return true;
    }
}
