public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 1;
        List<Integer> l = new LinkedList<Integer>();
        int flag = 0;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            count --;
            l.add(n.val);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
            if (count == 0) {
                count = q.size();
                if (flag==0) {
                    res.add(new LinkedList<Integer>(l));
                    l.clear();
                    flag = 1-flag;
                } else {
                    List<Integer> tmp = new LinkedList<Integer>();
                    for (int i=l.size()-1; i >=0; i--) {
                        tmp.add(l.get(i));
                    }
                    res.add(tmp);
                    flag = 1-flag;
                    l.clear();
                }
            }
        }

        return res;
    }
}
