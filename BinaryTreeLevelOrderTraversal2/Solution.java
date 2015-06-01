public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        TreeNode left = root.left;
        TreeNode right = root.right;
        List<List<Integer>>  leftLevelOrder = levelOrderBottom(left);
        List<List<Integer>>  rightLevelOrder = levelOrderBottom(right);
        result = bottomMerge(leftLevelOrder, rightLevelOrder);
        List<Integer> cur = new LinkedList<Integer>();
        cur.add(root.val);
        result.add(cur);

        return result;
    }

    private List<List<Integer>> bottomMerge(List<List<Integer>> left, List<List<Integer>> right) {
        if (left == null || left.size()==0)
            return right;
        if (right == null || right.size() == 0)
            return left;
        int diff=0, leftStart=0, rightStart;
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (left.size() <= right.size()) {
            diff = right.size() - left.size();
            leftStart = 0;
            rightStart = diff;
            for (int i=0; i < diff; i++) {
                result.add(right.get(i));
            }
        } else {
            diff = left.size() - right.size();
            leftStart = diff;
            rightStart = 0;
            for (int i=0; i < diff; i++) {
                result.add(left.get(i));
            }
        }

        for (int i=leftStart, j=rightStart; i < left.size() && j < right.size(); i++,j++) {
            List<Integer> mergedOne = new LinkedList<Integer>();
            mergedOne.addAll(left.get(i));
            mergedOne.addAll(right.get(j));
            result.add(mergedOne);
        }



        return result;

    }
}
