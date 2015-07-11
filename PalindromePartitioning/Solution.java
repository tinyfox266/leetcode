public class Solution {
    private void computeMark(String s, boolean mark[][]) {
        for (int i=0; i < s.length(); i++) {
            mark[i][i] = true;
        }

        for (int step=1; step < s.length(); step++) {
            for (int i=0; i+step < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i+step)) {
                    mark[i][i+step] = (step==1) || mark[i+1][i+step-1];
                } else {
                    mark[i][i+step] = false;
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        if (s == null || s.length() == 0)
            return res;

        boolean mark[][] = new boolean[s.length()][s.length()];

        computeMark(s, mark);

        return dfs(s, 0, mark);


    }

    public List<List<String>> dfs(String s, int start, boolean mark[][]) {
        List<List<String>> res = new LinkedList<List<String>>();
        if (start == s.length()-1) {
            List<String> lists = new LinkedList<String>();
            lists.add(s.substring(start,s.length()));
            res.add(lists);
            return res;
        }
        for (int i=start; i < s.length()-1; i++) {
            if (mark[start][i]) {
                List<List<String>> sub = dfs(s, i+1, mark);
                for (List<String> l: sub) {
                    List<String> merge = new LinkedList<String>();
                    merge.add(s.substring(start, i+1));
                    merge.addAll(l);
                    res.add(merge);
                }
            }
        }
        
        if (mark[start][s.length()-1]) {
            List<String> lists = new LinkedList<String>();
            lists.add(s.substring(start,s.length()));
            res.add(lists);
        }        

        return res;
    }
}

