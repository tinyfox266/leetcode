public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<Integer>();
        if (root == null)
            return view;
            
        view.add(root.val);

        TreeNode left = root.left;
        TreeNode right = root.right;
        
        List<Integer> leftView = rightSideView(root.left);
        List<Integer> rightView = rightSideView(root.right);
        int i;
        for (i=0; i < rightView.size(); i++) {
            view.add(rightView.get(i));
        }
        while (i < leftView.size()) {
            view.add(leftView.get(i));
            i++;
        }
        
        return view;
    }
}
