public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new LinkedList<Integer>();
        if (n < 0)
            return codes;
        if ( n == 0) {
            codes.add(0);
            return codes;
        }

        if (n == 1) {
            codes.add(0);
            codes.add(1);
            return codes;
        }
        List<Integer> codesprime = grayCode(n-1);
        for (int i=0; i < codesprime.size(); i++) {
            int code = codesprime.get(i);
            codes.add(code);
        }
        for (int i=codesprime.size()-1; i >= 0; i--) {
            int code = codesprime.get(i);
            codes.add((1<<(n-1)) + code);
        }

        return codes;
    }
}
