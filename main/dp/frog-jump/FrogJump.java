import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    public static void main(String[] args) {

    }

    private boolean recursion(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        HashSet<Integer> stonePos = new HashSet<>();

        for (int s : stones) {
            stonePos.add(s);
        }

        return recursionHelper(0, 1, stones[stones.length - 1], stonePos);
    }

    private boolean recursionHelper(int currPos, int k, int lastStone, HashSet<Integer> stonePos) {
        if (currPos == lastStone) {
            return true;
        }

        boolean result = false;

        if (k - 1 > 0 && stonePos.contains(currPos + k - 1)) {
            int currJump = k - 1;
            result = recursionHelper(currPos + k - 1, currJump, lastStone, stonePos);
        }

        if (!result && stonePos.contains(currPos + k)) {
            result = recursionHelper(currPos + k, k, lastStone, stonePos);
        }

        if (!result && stonePos.contains(currPos + k + 1)) {
            int currJump = k + 1;
            result = recursionHelper(currPos + k + 1, currJump, lastStone, stonePos);
        }

        return result;
    }

    private boolean topDownDp(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        int n = stones.length;
        Boolean[][] dp = new Boolean[n][n];

        HashMap<Integer, Integer> stoneVsIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            stoneVsIdx.put(stones[i], i);
        }

        return topDownDpHelper(0, 0, stones, stoneVsIdx, dp);
    }

    private boolean topDownDpHelper(int currStoneIdx, int prevStoneIdx, int[] stones,
        HashMap<Integer, Integer> stoneVsIdx, Boolean[][] dp) {
        if (currStoneIdx == stones.length - 1) {
            return true;
        }

        if (currStoneIdx >= stones.length) {
            return false;
        }

        if (dp[currStoneIdx][prevStoneIdx] != null) {
            return dp[currStoneIdx][prevStoneIdx];
        }

        boolean result = false;

        int k = stones[currStoneIdx] - stones[prevStoneIdx];

        if (k - 1 > 0 && stoneVsIdx.containsKey(stones[currStoneIdx] + k - 1)) {
            result =
                topDownDpHelper(stoneVsIdx.get(stones[currStoneIdx] + k - 1), currStoneIdx, stones,
                    stoneVsIdx, dp);
        }

        if (k > 0 && !result && stoneVsIdx.containsKey(stones[currStoneIdx] + k)) {
            result = topDownDpHelper(stoneVsIdx.get(stones[currStoneIdx] + k), currStoneIdx, stones,
                stoneVsIdx, dp);
        }

        if (!result && stoneVsIdx.containsKey(stones[currStoneIdx] + k + 1)) {
            result =
                topDownDpHelper(stoneVsIdx.get(stones[currStoneIdx] + k + 1), currStoneIdx, stones,
                    stoneVsIdx, dp);
        }

        return dp[currStoneIdx][prevStoneIdx] = result;
    }
}
