public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if (s.length() < 4 || s.length() > 12)
            return ret;


        return helper(s, 4);

    }

    private boolean isValid(String s) {
        if (s == null || s.length() > 3 || s.length() == 0)
            return false;
        if (s.length() > 1) {
            if (s.charAt(0) == '0')
                return false;
        }
        if (Integer.parseInt(s) <= 255)
            return true;

        return false;
    }

    private List<String> helper(String s, int idx) {
        List<String> ret = new LinkedList<String>();

        if (idx == 1) {
            if (isValid(s)) {
                ret.add(s);
                return ret;
            } else {
                return ret;
            }
        }

        if (s.length() < idx || s.length() > idx*3)
            return ret;

        for (int i=1; i <= 3; i++) {
            if (i > s.length()) {
                break;
            }
            String sub = s.substring(0,i);
            if (! isValid(sub))
                continue;
            List<String> l1 = helper(s.substring(i,s.length()), idx-1);
            for (String r: l1) {
                ret.add(sub+'.'+r);
            }
        }

        return ret;

    }
}
