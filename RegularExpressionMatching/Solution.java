public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null)
            return s==null;
        if (s == null)
            return false;
        if (p.length() == 0)
            return s.length() == p.length();

        if (p.length() == 1) {
            if (p.equals(s) || (s.length() == 1 && p.charAt(0) == '.')) {
                return true;
            } else {
                return false;
            }
        }

        if (p.charAt(1) != '*') {
            if (s.length() == 0)
                return false;

            if (p.charAt(0) != s.charAt(0) && (p.charAt(0) != '.'))
                return false;

            return isMatch(s.substring(1), p.substring(1));
        } else {
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }

            return isMatch(s, p.substring(2));
        }

    }
}
