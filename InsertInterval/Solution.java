public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        boolean flag=false;
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                if (! flag) {
                    result.add(newInterval);
                    flag = true;
                }
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }

        }

        if (!flag)
            result.add(newInterval);

        return result;
    }
}
