import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] input = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;

        int choice = Math.abs(new Random().nextInt() % 4);
        int result = switch (choice) {
            case 0 -> minHeapImplOne(input, k);
            case 1 -> minHeapImplTwo(input, k);
            case 2 -> sorting(input, k);
            case 3 -> quickSelectImpl(input, k);
            default -> 0;
        };

        System.out.println(result);
    }

    private static int minHeapImplOne(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == k) {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            } else {
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }

    private static int minHeapImplTwo(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    private static int sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static int quickSelectImpl(int[] nums, int k) {
        int idx = quickSelect(0, nums.length - 1, k, nums);
        return nums[idx];
    }

    private static int quickSelect(int l, int r, int k, int[] nums) {
        int res = 0;
        if (l <= r) {
            res = partition(l, r, nums);

            if (res == k - 1) {
                return res; // partitioned at k
            } else if (res < k - 1) {
                l = res + 1; // k lies in right half
            } else {
                r = res - 1; // k lies in left half
            }

            res = quickSelect(l, r, k, nums);
        }

        return res;
    }

    // all elements greater than pivot should be on the left of pivot
    private static int partition(int l, int r, int[] nums) {
        int pivot = l; // select first element as pivot

        int i = l;
        int j = r;

        while (i < j) {
            while (i < r && nums[pivot] < nums[i]) {
                i++;
            }

            while (j > l && nums[pivot] >= nums[j]) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, pivot, j);

        return j;
    }

    private static void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }

}
