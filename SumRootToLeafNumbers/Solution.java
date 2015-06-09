public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        List<String> allPaths = allPaths(root);
        int sum=0;
        for (String s:allPaths) {
            sum += Integer.parseInt(s);
        }


        return sum;
    }

    public List<String> allPaths(TreeNode root) {
        List<String> res = new LinkedList<String>();

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
        }

        if (root.left != null) {
            List<String> leftPaths = allPaths(root.left);
            for (String s: leftPaths) {
                res.add(root.val + s);
            }
        }

        if (root.right != null) {
            List<String> rightPaths = allPaths(root.right);
            for (String s: rightPaths) {
                res.add(root.val + s);
            }
        }

        return res;
    }
}
