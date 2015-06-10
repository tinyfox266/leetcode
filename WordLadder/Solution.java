public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Map<String, Boolean> visited = new HashMap<String,Boolean>();
        for (String s:wordDict) {
            visited.put(s,false);
        }

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        visited.put(beginWord, true);
        int level=1;
        int count = 1;
        while ( !q.isEmpty() ) {
            String s = q.poll();
            count --;
            for (int i=0; i < s.length(); i++) {
                for (char c='a'; c <= 'z'; c++) {
                    if (s.charAt(i) == c)
                        continue;
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i,c);
                    String sbStr = sb.toString();

                    if (sbStr.equals(endWord))
                        return level+1;
                    if (wordDict.contains(sbStr)) {
                        if (visited.get(sbStr)==true)
                            continue;
                        q.add(sbStr);
                        visited.put(sbStr, true);
                    }
                }
            }
            if (count == 0) {
                count = q.size();
                level++;

            }
        }

        return 0;
    }
}
