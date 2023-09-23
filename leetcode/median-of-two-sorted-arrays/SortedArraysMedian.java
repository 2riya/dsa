public class SortedArraysMedian {
    public static void main(String[] args) {

    }

    private static double findMedianSortedArraysLinear(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        int idx2 = total / 2;
        int idx1 = total % 2 == 0 ?
            idx2 - 1 :
            idx2; // for odd no. of elements, only 1 median will be there

        int median1 = 0;
        int median2 = 0;

        int p1 = 0; // for nums1
        int p2 = 0; // for nums2
        int p3 = 0; // for merging nums1 and nums2

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                if (p3 == idx1) {
                    median1 = nums1[p1];
                }

                if (p3 == idx2) {
                    median2 = nums1[p1];
                }

                p1++;
            } else {
                if (p3 == idx1) {
                    median1 = nums2[p2];
                }

                if (p3 == idx2) {
                    median2 = nums2[p2];
                }

                p2++;
            }

            // if both median1 and median2 are found, then no need to traverse further
            if (p3 > idx1 && p3 > idx2) {
                break;
            }

            p3++;
        }

        while (p3 <= idx2 && p1 < m) {
            if (p3 == idx1) {
                median1 = nums1[p1];
            }

            if (p3 == idx2) {
                median2 = nums1[p1];
            }

            p1++;
            p3++;
        }

        while (p3 <= idx2 && p2 < n) {
            if (p3 == idx1) {
                median1 = nums2[p2];
            }

            if (p3 == idx2) {
                median2 = nums2[p2];
            }

            p2++;
            p3++;
        }

        return (median2 + median1) / 2.0;
    }

    public static double findMedianSortedArraysBinarySearch(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArraysBinarySearch(b, a);
        }

        int m = a.length;
        int n = b.length;

        int len = m + n;

        int lo = 0;
        int hi = m;

        while (lo <= hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            int x = mid;
            int y = (len / 2) - mid;

            int l1 = x == 0 ? Integer.MIN_VALUE : a[x - 1];
            int l2 = y == 0 ? Integer.MIN_VALUE : b[y - 1];

            int r1 = x == m ? Integer.MAX_VALUE : a[x];
            int r2 = y == n ? Integer.MAX_VALUE : b[y];

            if (l1 <= r2 && l2 <= r1) {
                double median;
                if (len % 2 == 0) {
                    median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    median = Math.min(r1, r2);
                }

                return median;
            } else if (l1 > r2) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
