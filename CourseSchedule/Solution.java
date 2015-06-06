public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0)
            return true;
        Set<Integer> noPreSet = new HashSet<Integer>();
        List<int []> preList = new LinkedList<int []>();
        Map<Integer, List<Integer>> preMap = new HashMap<Integer, List<Integer>>();
        int [] dependCount = new int [numCourses];
        Arrays.fill(dependCount, 0);
        for (int i=0; i < numCourses; i++) {
            noPreSet.add(i);
            preMap.put(i, new LinkedList<Integer>());
        }

        for (int i=0; i < prerequisites.length; i++) {
            preList.add(prerequisites[i]);
            int left = prerequisites[i][0];
            int right = prerequisites[i][1];

            preMap.get(right).add(left);
            dependCount[left]++;
            noPreSet.remove(left);
        }

        while (!noPreSet.isEmpty()) {
            List<Integer> noPreSetCache = new LinkedList<Integer>(noPreSet);
            for (int c: noPreSetCache) {
                noPreSet.remove(c);
                for (int pre: preMap.get(c)) {
                    dependCount[pre]--;
                    if (dependCount[pre] == 0)
                        noPreSet.add(pre);
                }
            }
        }

        for (int i=0; i < numCourses; i++) {
            if (dependCount[i] != 0)
                return false;
        }

        return true;



    }
}
