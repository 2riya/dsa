public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 1, 1, 2, 0, 0};
        mergeSort(0, nums.length - 1, nums);
    }

    private static void mergeSort(int left, int right, int[] nums) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid, nums);
            mergeSort(mid + 1, right, nums);
            merge(left, right, nums);
        }
    }

    private static void merge(int leftPtr, int rightPtr, int[] nums) {
        int mid = (leftPtr + rightPtr) / 2;

        int[] leftArray = new int[mid - leftPtr + 1];
        int[] rightArray = new int[rightPtr - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = nums[i + leftPtr];
        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = nums[i + mid + 1];
        }

        int i = 0;
        int j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                nums[leftPtr++] = leftArray[i++];
            } else {
                nums[leftPtr++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            nums[leftPtr++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            nums[leftPtr++] = rightArray[j++];
        }
    }

}
