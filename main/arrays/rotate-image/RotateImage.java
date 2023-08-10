public class RotateImage {
    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(input);
        rotate2(input);
    }

    private static void rotate(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < (n - i - 1); j++) {
                System.out.println("rot");
                // i,j -> j,(n-i) -> (n-i),(n-j) -> (n-j),i -> i,j
                int temp = a[i][j];
                a[i][j] = a[n - j - 1][i];
                a[n - j - 1][i] = a[n - i - 1][n - j - 1];
                a[n - i - 1][n - j - 1] = a[j][n - i - 1];
                a[j][n - i - 1] = temp;
            }
        }
    }

    /* Transpose and reverse */
    private static void rotate2(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap i j -> j i
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(a[i]);
        }
    }

    private static void reverse(int a[]) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
}
