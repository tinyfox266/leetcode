public class Solution {
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        return numDecodings_(s);
    }

    public int numDecodings_(String s) {
        if (s == null || s.length() == 0)
            return 1;

        if (map.get(s) != null)
            return map.get(s);

        if (s.charAt(0) == '0') {
            map.put(s, 0);
            return 0;
        }

        if (s.length() == 1) {
            if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
                map.put(s, 1);
                return 1;
            }
            else {
                map.put(s,0);
                return 0;
            }
        }

        char c1=s.charAt(0), c2=s.charAt(1);


        int ways=0, ways1=0, ways2=0;


        if ((c1 == '1') || (c1 == '2' && (c2 >= '0' && c2 < '7'))) {
            ways2 = numDecodings_(s.substring(2));
        }
        if (c1 > '0' && c1 <= '9') {
            ways1 = numDecodings_(s.substring(1));
        }
        map.put(s, ways1 + ways2);
        return ways1 + ways2;


    }
}
