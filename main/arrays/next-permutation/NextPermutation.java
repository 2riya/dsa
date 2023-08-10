public class NextPermutation {
    public static void main(String[] args) {
        int[] input = new int[] {3, 2, 1};

        nextPermutation(input);
    }

    private static void nextPermutation(int[] nums) {
        int pivot = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        int swapIdx = 0;
        for (int i = pivot + 1; i < nums.length; i++) {
            if (nums[i] > nums[pivot]) {
                swapIdx = i;
            }
        }

        swap(nums, pivot, swapIdx);

        int left = pivot == swapIdx ?
            pivot : // To handle cases with last permutation, e.g.:  [3, 2, 1], where entire array needs to be reversed
            pivot + 1;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private static void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}
