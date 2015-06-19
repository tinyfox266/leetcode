public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2==1) {
            return kth(nums1, 0, nums2, 0, len/2+1);
        } else {
            return (kth(nums1, 0, nums2, 0, len/2) +
                    kth(nums1, 0, nums2, 0, len/2+1))/2.0;
        }
    }

    public int kth(int a[], int m, int b[], int n, int k) {
        // assume m <= n
        if (a.length-m+1 > b.length-n+1) return kth(b, n, a, m, k);

        if (m >= a.length) {
            return b[n+k-1];
        }

        if (k == 1) {
            return Math.min(a[m], b[n]);
        }

        int ia = Math.min(m+k/2-1, a.length-1), ib=n+k-(ia-m+1)-1;
        if (a[ia] == b[ib]) {
            return a[ia];
        } else if (a[ia] < b[ib]) {
            return kth(a, ia+1, b, n, k-(ia-m+1));
        } else {
            return kth(a, m, b, ib+1, k-(ib-n+1));
        }
    }
}
