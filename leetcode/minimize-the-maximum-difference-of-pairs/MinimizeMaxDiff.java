import java.util.Arrays;

public class MinimizeMaxDiff {
    public static void main(String[] args) {
        int[] input = new int[] {3, 4, 2, 3, 2, 1, 2};
        minimizeMax(input, 3);
    }

    private static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int maxDiff = nums[nums.length - 1] - nums[0];

        int lo = 0;
        int hi = maxDiff;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (possibleToMakeRequiredPairs(nums, p, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi + 1;
    }

    private static boolean possibleToMakeRequiredPairs(int[] nums, int p, int diff) {
        int pairCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= diff) {
                pairCount++;
                i++; // since both curr and next element constitute a valid pair, therefore move i forward by 2
            }
        }

        return pairCount >= p;
    }

    private static int minimizeMax2(int[] a, int p) {
        Arrays.sort(a);

        int[] diff = new int[a.length];
        Arrays.fill(diff, Integer.MAX_VALUE);

        boolean r = false;

        for (int i = 1; i < a.length - 1; i++) {
            int ldiff = a[i] - a[i - 1];
            int rdiff = a[i + 1] - a[i];

            System.out.println(" " + ldiff + " " + rdiff);

            if (ldiff < rdiff) {
                if (diff[i - 1] > ldiff) {
                    diff[i - 1] = Integer.MAX_VALUE;
                    diff[i] = ldiff;
                    r = false;
                } else if (!r) {
                    diff[i] = rdiff;
                    r = true;
                }
            } else if (!r) {
                diff[i] = rdiff;
                r = true;
            }

            System.out.println(i + " " + diff[i]);
        }

        Arrays.sort(diff);

        int ans = 0;
        for (int i = 1; i <= p; i++) {
            ans = diff[i];
            System.out.println(" " + i + " " + diff[i]);
        }

        return ans;
    }
}
