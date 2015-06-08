public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;

        if (isLeaf(root) && root.val == sum) {
            List<Integer> l = new LinkedList<Integer>();
            l.add(root.val);
            res.add(l);
        } else if (isLeaf(root) && root.val != sum) {
            return res;
        }

        List<List<Integer>> resLeft = pathSum(root.left, sum-root.val);
        List<List<Integer>> resRight = pathSum(root.right, sum-root.val);
        for (List<Integer> l:resLeft) {
            l.add(0, root.val);
            res.add(l);
        }
        for (List<Integer> l:resRight) {
            l.add(0, root.val);
            res.add(l);
        }

        return res;
    }

    private boolean isLeaf(TreeNode n) {
        if (n == null)
            return false;
        return n.left == null && n.right == null;
    }
}
