public class SortColors {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,0};
        sort(input);
    }

    private static void sort(int[] arr) {
        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;
        while (mid <= hi) {
            if (arr[mid] == 0) {
                swap(arr, lo, mid);
                lo++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, hi, mid);
                hi--;
            }
        }
    }

    private static void swap(int[] arr, int leftIdx, int rightIdx) {
        int temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
    }
}
