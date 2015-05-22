public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelElems = new LinkedList<List<Integer>>();

        if (root == null)
            return levelElems;

        List<Integer> currrentLevel = new LinkedList<Integer>();
        currrentLevel.add(root.val);
        List<List<Integer>> leftLevel = levelOrder(root.left);
        List<List<Integer>> rightLevel = levelOrder(root.right);

        levelElems.add(currrentLevel);

        if (leftLevel == null && rightLevel == null) {
            return levelElems;
        } else if (leftLevel != null && rightLevel == null) {
            levelElems.addAll(leftLevel);
            return levelElems;
        } else if (leftLevel == null && rightLevel != null) {
            levelElems.addAll(rightLevel);
            return levelElems;
        } else {
            if (leftLevel.size() >= rightLevel.size()) {
                for (int i=0; i < rightLevel.size(); i++) {
                    leftLevel.get(i).addAll(rightLevel.get(i));
                }
                levelElems.addAll(leftLevel);
            } else {
                int i;
                List<Integer> tmpList = new LinkedList<Integer>();
                for (i=0; i < leftLevel.size(); i++) {
                    tmpList.addAll(leftLevel.get(i));
                    tmpList.addAll(rightLevel.get(i));
                    levelElems.add(new LinkedList<Integer>(tmpList));
                    tmpList.clear();
                }
                for (int j=i; j < rightLevel.size(); j++) {
                    levelElems.add(rightLevel.get(j));
                }
            }
        }

        return levelElems;
    }
}
