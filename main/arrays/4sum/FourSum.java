import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        int[] input = new int[]{};


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Set<Integer>> list = new HashSet<>();
        HashMap<Integer, Integer> numVsIdx = new HashMap<>();

        for (int a = 0; a < nums.length - 2; a++) {
            for (int b = a + 1; b < nums.length - 1; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    int tempSum = nums[a] + nums[b] + nums[c];
                    if (numVsIdx.containsKey(target - tempSum)) {
                        Set<Integer> res = new HashSet<>();
                        res.add(nums[a]);
                        res.add(nums[b]);
                        res.add(nums[numVsIdx.get(target - tempSum)]);
                        res.add(nums[c]);
                        list.add(res);
                    } else {
                        numVsIdx.put(nums[c], c);
                    }
                }
            }
        }

        return list.stream()
            .map(s -> s.stream().toList())
            .toList();
    }
}
