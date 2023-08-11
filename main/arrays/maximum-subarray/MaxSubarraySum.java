import java.util.Random;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int choice = Math.abs(new Random().nextInt() % 3);
        int result = switch (choice) {
            case 0 -> bruteForce(arr);
            case 1 -> bruteForceOptimized(arr);
            case 2 -> kadanesAlgo(arr);
            default -> 0;
        };

        System.out.println(result);
    }

    private static int kadanesAlgo(int[] a) {
        int result = Integer.MIN_VALUE;
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum > result) {
                result = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }


        return result;
    }

    private static int bruteForce(int[] a) {
        int result = Integer.MIN_VALUE;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                result = Math.max(result, sum);
            }
        }


        return result;
    }

    private static int bruteForceOptimized(int[] a) {
        int result = Integer.MIN_VALUE;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                result = Math.max(result, sum);
            }
        }


        return result;
    }
}
