public class MergeSortedArraysInsideFirstArray {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] b = new int[] {2, 5, 6};
        int n = 3;
        merge(a, m, b, n);
    }

    private static void merge(int[] a, int m, int[] b, int n) {
        m--;
        n--;
        int right = a.length - 1;

        while (m >= 0 && n >= 0) {
            if (a[m] >= b[n]) {
                a[right] = a[m];
                m--;
            } else {
                a[right] = b[n];
                n--;
            }
            right--;
        }

        while (right >= 0 && n >= 0) {
            a[right] = b[n];
            n--;
            right--;
        }

        while (right >= 0 && m >= 0) {
            a[right] = a[m];
            m--;
            right--;
        }
    }
}
