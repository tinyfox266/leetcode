public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;

        int index1=0, index2=0, index3=0;

        int [] ugly = new int[n];
        ugly[0] = 1;

        for (int i=1; i < n; i++) {
            int mini=index1;
            int min=ugly[index1]*2;

            if (ugly[index2]*3 < min) {
                mini = index2;
                min=ugly[index2]*3;
            }

            if (ugly[index3]*5 < min) {
                mini = ugly[index3]*5;
                min = ugly[index3]*5;
            }

            ugly[i] = min;
            if (ugly[index1]*2 == min) {
                index1++;
            }
            if (ugly[index2]*3 == min) {
                index2++;
            }
            if (ugly[index3]*5 == min) {
                index3++;
            }
        }

        return ugly[n-1];

    }
}
