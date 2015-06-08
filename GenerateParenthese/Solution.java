public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        if (n==0)
            return res;
        if (n==1) {
            res.add("()");
            return res;
        }

        List<String> resPrime = generateParenthesis(n-1);
        for (String s: resPrime) {
            for (int i=0; i < s.length(); i++) {
                String tmp = s.substring(0,i) + "()" + s.substring(i, s.length());
                if (!res.contains(tmp))
                    res.add(tmp);
            }
        }

        return res;
    }
}
