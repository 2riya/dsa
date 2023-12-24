import java.util.Arrays;

public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 10};
        int target = 19;

        int result = minPatches(nums, target);

        System.out.println(result);
    }

    private static int minPatches(int[] nums, int target) {
        Arrays.sort(nums); // ensure nums is sorted in ascending order

        int x = 1;
        int patches = 0;

        for (int num : nums) {
            while (x < num) {
                patches++;
                x += x;
            }

            x += num;

            if (x > target) {
                return patches;
            }
        }

        while (x <= target) {
            patches++;
            x += x;
        }

        return patches;
    }
}
