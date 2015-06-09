public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return maxAndMinAndValidBST(root) != null;
    }

    public Pair<Integer,Integer> maxAndMinAndValidBST(TreeNode root) {
        // assume root is not null
        // return value is null means it is not valid BST
        if (root.left == null && root.right == null)
            return new Pair<Integer,Integer>(root.val, root.val);

        if (root.left == null) {
            Pair<Integer,Integer> right = maxAndMinAndValidBST(root.right);
            if (right == null)
                return null;
            if (root.val >= right.min)
                return null;
            return new Pair<Integer,Integer>(root.val, right.max);
        }

        if (root.right == null) {
            Pair<Integer,Integer> left = maxAndMinAndValidBST(root.left);
            if (left == null)
                return null;
            if (left.max >= root.val)
                return null;
            return new Pair<Integer,Integer>(left.min, root.val);
        }


        Pair<Integer,Integer> right = maxAndMinAndValidBST(root.right);
        Pair<Integer,Integer> left = maxAndMinAndValidBST(root.left);

        if (right == null || left == null)
            return null;
        if (left.max >= root.val || root.val >= right.min)
            return null;

        return new Pair<Integer,Integer>(left.min, right.max);
    }

    class Pair<K,V> {
        public K min;
        public V max;
        public Pair(K k, V v) {
            this.min = k;
            this.max = v;
        }
    }
}
