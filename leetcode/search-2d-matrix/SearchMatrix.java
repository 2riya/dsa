import java.util.Random;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 11;

        int choice = new Random().nextInt() % 3;
        boolean result = switch (choice) {
            case 0 -> logMN(matrix, target);
            case 1 -> logMNv2(matrix, target);
            case 2 -> NlogM(matrix, target);
            default -> false;
        };

        System.out.println(result);
    }

    private static boolean logMN(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = (m * n) - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid / n][mid % n] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo > 0 && matrix[(lo - 1) / n][(lo - 1) % n] == target;
    }

    private static boolean NlogM(int[][] matrix, int target) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target) {
                row = i;
            }
        }

        int lo = 0;
        int hi = matrix[0].length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo > 0 && matrix[row][lo - 1] == target;
    }

    private static boolean logMNv2(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        int row = lo - 1;

        if (row < 0) {
            return false;
        }

        lo = 0;
        hi = matrix[row].length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo > 0 && matrix[row][lo - 1] == target;
    }
}
