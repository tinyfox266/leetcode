public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        
        List<Interval> res = new LinkedList<Interval>();
        Interval pre = null;
        for (Interval inter: intervals) {
            if (pre == null || inter.start > pre.end) {
                res.add(inter);
                pre = inter;
            } else if (inter.end > pre.end){
                pre.end = inter.end;
            }
        }
        
        return  res;
    }
}
