public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] preCount = new int[numCourses];
        Map<Integer, List<Integer>>  table = new HashMap<Integer, List<Integer>>();
        Arrays.fill(preCount,0);
        List<Integer> noPreSet = new LinkedList<Integer>();
        for (int i=0; i < prerequisites.length; i++) {
            preCount[prerequisites[i][0]]++;
            if (table.get(prerequisites[i][1]) == null) {
                table.put(prerequisites[i][1], new LinkedList<Integer>());
            }
            List<Integer> l = table.get(prerequisites[i][1]);
            l.add(prerequisites[i][0]);
        }
        for (int i=0; i < numCourses; i++) {
            if (preCount[i] == 0)
                noPreSet.add(i);
        }
        if (noPreSet.isEmpty())
            return new int [0];
        int [] order = new int[numCourses];
        int index=0;
        while (index < numCourses) {
            if (noPreSet.isEmpty())
                return new int [0];
            List<Integer> noPreSetCache = new LinkedList<Integer>(noPreSet);
            for (int n:noPreSetCache) {
                order[index] = n;
                noPreSet.remove((Integer) n);
                index++;
                if (table.get(n) == null)
                    continue;
                for (int post: table.get(n)) {
                    preCount[post]--;
                    if (preCount[post] == 0)
                        noPreSet.add(post);
                }
            }

        }
        return order;
    }
}
