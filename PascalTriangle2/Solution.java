public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> row = new LinkedList<>();
            row.add(1);
            return (row);
        }
        
        List<Integer> row;
        List<Integer> initRow = new LinkedList<Integer>();
        initRow.add(new Integer(1));
        initRow.add(new Integer(1));
        row = initRow;
        for (int i=1; i<rowIndex; i++) {
            row = nextRow(row);
        }
        return row;
    }
    
   public  List<Integer> nextRow(List <Integer> currRow) {
        List<Integer> nextRow = new LinkedList();
        nextRow.add(1);
        for (int i=0; i < currRow.size()-1; i++) {
            Integer item = currRow.get(i) + currRow.get(i+1);
            nextRow.add(item);
        }
        nextRow.add(1);
        return nextRow;

   }
}
