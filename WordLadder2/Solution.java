public class Solution {
    // when restore the path, a path is added to res immediately once found.
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        List<List<String>> res = new LinkedList<List<String>>();
        if (dict == null || dict.size() == 0)
            return res;

        HashMap<String, Integer> level = new HashMap<String, Integer>();

        bfs(start, end, dict, level);
        
        if (level.get(end) == null)
            return res;        

        dfs(end, start, level, res, new LinkedList<String>(), level.get(end));

        return res;

    }

    public void bfs(String start, String end, Set<String> dict, HashMap<String, Integer> level) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        level.put(start, 1);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(end)) {
                continue;
            }
            for (int i=0; i < cur.length(); i++) {
                for (char c='a'; c <= 'z'; c++) {
                    if (c == cur.charAt(i))
                        continue;

                    String next = cur.substring(0,i) + c + cur.substring(i+1);


                    if (dict.contains(next) && level.get(next) == null) {
                        queue.add(next);
                        level.put(next, level.get(cur)+1);
                    }
                }
            }
        }
    }

    public void dfs(String cur, String start, HashMap<String, Integer> level,
                    List<List<String>> res, List<String> path,
                    int curLevel) {
        if (cur.equals(start)) {
            path.add(start);
            Collections.reverse(path);
            res.add(path);
        }

        if (level.get(cur) > curLevel)
            return;

        for (int i=0; i < cur.length(); i++) {
            for (char c='a'; c <= 'z'; c++) {
                if (c == cur.charAt(i))
                    continue;

                String next = cur.substring(0,i) + c + cur.substring(i+1);

                if (level.get(next) == null)
                    continue;

                List<String> newPath = new LinkedList<String>(path);
                newPath.add(cur);
                dfs(next, start, level, res, newPath, curLevel-1);
            }
        }
    }
}

