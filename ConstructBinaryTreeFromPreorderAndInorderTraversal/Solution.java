public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preorderBegin, int preorderEnd,
                              int inorderBegin, int inorderEnd) {
        if (preorderBegin > preorderEnd || inorderBegin > inorderEnd)
            return null;

        if (preorderBegin == preorderEnd)
            return new TreeNode(preorder[preorderBegin]);

        int rootValue = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex=0;
        for (int i=inorderBegin; i <= inorderEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        TreeNode left = buildTree(preorder, inorder, preorderBegin+1, preorderBegin+1+rootIndex-1-inorderBegin ,
                inorderBegin, rootIndex-1);
        TreeNode right = buildTree(preorder, inorder, preorderBegin+1+rootIndex-1-inorderBegin+1, preorderEnd,
                rootIndex+1, inorderEnd);
        root.left = left;
        root.right = right;

        return root;

    }
}
