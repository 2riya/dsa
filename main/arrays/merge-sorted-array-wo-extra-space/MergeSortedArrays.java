import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = new int[] {1, 8, 8};
        int[] b = new int[] {2, 3, 4, 5};
        mergeSortedArrays(a, b);
    }

    private static void mergeSortedArrays(int[] a, int[] b) {
        int leftPtr = a.length - 1;
        int rightPtr = 0;

        while (leftPtr >= 0 && rightPtr < b.length && a[leftPtr] > b[rightPtr]) {
            swap(a, leftPtr--, b, rightPtr++);
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    private static void swap(int[] arr1, int idx1, int[] arr2, int idx2) {
        int temp = arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
    }
}
