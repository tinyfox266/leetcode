public class Solution {
    
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1, n);
    }
    
    public List<TreeNode> generateTrees(int n, int begin, int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();

        if (n == 0) {
            res.add(null);
            return res;
        }

        if (n == 1) {
            res.add(new TreeNode(begin));
            return res;
        }

        for (int i=0; i < n; i++) {
            List<TreeNode> leftTrees = generateTrees(i, begin, begin+i-1);
            List<TreeNode> rightTrees = generateTrees(n-1-i,begin+i+1, end);
            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {
                    TreeNode root = new TreeNode(begin+i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
