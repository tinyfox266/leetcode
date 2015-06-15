/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;

        if (points.length == 1)
            return 1;

        Map<Double, Integer> sameSlope = new HashMap<Double, Integer>();
        int max = 0;
        int verticalLine = 0;
        int samePoints = 0;
        int curMax = 0;
        for (int i=0; i < points.length; i++) {
            for (int j=0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y != points[j].y)
                        verticalLine++;
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePoints++;
                    }
                    else {
                        double k = ((double)(points[i].y - points[j].y))/(points[i].x - points[j].x);
                        if (sameSlope.get(k) == null) {
                            curMax = Math.max(curMax, 1);
                            sameSlope.put(k, 1);
                        } else {
                            sameSlope.put(k, sameSlope.get(k)+1);
                            curMax = Math.max(curMax, sameSlope.get(k));
                        }
                    }
                }
            }
            max = Math.max(max, verticalLine+samePoints);
            max = Math.max(max, curMax+samePoints);
            curMax = 0;
            samePoints = 0;
            verticalLine = 0;
            sameSlope.clear();
        }

        return max+1;
    }
}
