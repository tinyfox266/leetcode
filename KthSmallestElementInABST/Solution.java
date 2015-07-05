/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushLeft(stack, root);
        while (k > 0) {
            TreeNode node = stack.pop();
            if (k == 1)
                return node.val;
            k--;
            pushLeft(stack, node.right);
        }

        return 0;
    }

    public void pushLeft(Stack stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
