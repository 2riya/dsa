public class CountSubArrays {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long result = countSubArrays(nums, k);
        System.out.println(result);
    }

    private static long countSubArrays(int[] nums, int k) {
        int n = nums.length;

        // find max element
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        long subArrayCount = 0;
        int maxElementCount = 0;

        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] == max) {
                maxElementCount++;
            }

            // once valid window is found, count subarrays and keep incrementing left pointer
            while (maxElementCount >= k && left <= right) {
                subArrayCount += n - right;

                if (nums[left] == max) {
                    maxElementCount--;
                }

                left++;
            }

            right++;
        }

        return subArrayCount;
    }
}
