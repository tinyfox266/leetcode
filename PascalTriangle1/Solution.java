public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new LinkedList<List<Integer>>();
        List<Integer> next = new LinkedList<Integer>();
        next.add(1);
        for (int i=0; i < numRows; i++) {
            pascalTriangle.add(next);
            next = nextRow(next);
        }
        return pascalTriangle;
    }

    public List<Integer> nextRow(List<Integer> cur) {
        List<Integer> next = new LinkedList<Integer>();
        next.add(1);
        for (int i=0; i < cur.size()-1; i++) {
            next.add(cur.get(i) + cur.get(i+1));
        }
        next.add(1);

        return next;
    }
}
