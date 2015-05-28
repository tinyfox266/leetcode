public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = new String();
        if (strs.length == 0)
            return common;
        if (strs.length == 1)
            return strs[0];
        for (int j=0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    return common;
                } else {
                    if(c != strs[i].charAt(j))
                        return common;
                }
            }
            common += c;
        }
        return common;
    }
}
