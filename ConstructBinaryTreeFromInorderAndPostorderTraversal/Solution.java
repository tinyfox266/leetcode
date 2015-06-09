public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;

        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                              int inorderBegin, int inorderEnd,
                              int postorderBegin, int postorderEnd) {
        if (inorderBegin > inorderEnd || postorderBegin > postorderEnd)
            return null;

        if (inorderBegin == inorderEnd)
            return new TreeNode(inorder[inorderBegin]);

        int rootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexInorder = 0;
        for (int i = inorderBegin; i <= inorderEnd; i++) {
            if (rootValue == inorder[i]) {
                rootIndexInorder = i;
                break;
            }
        }
        TreeNode left = buildTree(inorder, postorder,
                inorderBegin, rootIndexInorder - 1,
                postorderBegin, postorderBegin + (rootIndexInorder - 1 - inorderBegin));
        TreeNode right = buildTree(inorder, postorder,
                rootIndexInorder + 1, inorderEnd,
                postorderBegin + (rootIndexInorder - inorderBegin), postorderEnd - 1);
        root.left = left;
        root.right = right;

        return root;

    }
}
