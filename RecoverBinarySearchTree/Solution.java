public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode [] targets = new TreeNode[2];
        Arrays.fill(targets, null);
        recoverTree(root, null, targets);
        if (targets[0] != null && targets[1] != null) {
            int v = targets[0].val;
            targets[0].val = targets[1].val;
            targets[1].val = v;
        }

    }

    public TreeNode recoverTree(TreeNode root, TreeNode pre, TreeNode[] targets) {
        if (root.left != null) {
            pre = recoverTree(root.left, pre, targets);
        }

        if (pre != null) {

            if (root.val < pre.val) {
                if (targets[0] == null)
                    targets[0] = pre;
                targets[1] = root;
            }
        }

        if (root.right != null)
            return recoverTree(root.right, root, targets);

        return root;
    }
}
