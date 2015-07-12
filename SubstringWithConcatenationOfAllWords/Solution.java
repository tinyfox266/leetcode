public class Solution {
    // similar method with Longest Substring Without Repeating Characters
     public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i=0; i < words.length; i++) {
            String word = words[i];
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word)+1);
            }
        }

        int left=0;
        int len = words[0].length();
        int count=0;

        for (int i=0; i < len; i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            count = 0;
            for (int j=i; j+len-1 < s.length(); j+=len) {
                String sub = s.substring(j, j+len);
                if (map.containsKey(sub)) {
                    if (count == 0)
                        left = j;
                    count++;

                    if (curMap.get(sub) == null) {
                        curMap.put(sub, 1);
                    } else {
                        curMap.put(sub, curMap.get(sub)+1);
                    }

                    while (curMap.get(sub) > map.get(sub)) {
                        String tmp = s.substring(left, left+len);
                        curMap.put(tmp, curMap.get(tmp)-1);
                        count--;
                        left = left+len;
                    }

                    if (count == words.length) {
                        res.add(left);
                        String tmp = s.substring(left, left+len);
                        curMap.put(tmp, curMap.get(tmp)-1);
                        count--;
                        left = left+len;


                    }
                } else {
                    curMap.clear();
                    count = 0;
                }
            }
        }

        return res;
    }
}

