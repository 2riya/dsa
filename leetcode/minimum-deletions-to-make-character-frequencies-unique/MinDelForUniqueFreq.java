import java.util.*;

public class MinDelForUniqueFreq {
    public static void main(String[] args) {
        String str = "bbcebab";
        int result = minDeletionsBySorting(str);
        result = minDeletions(str);
    }

    private static int minDeletions(String str) {
        char[] s = str.toCharArray();

        HashMap<Character, Integer> characterVsFrequencyMap = new HashMap<>();
        for (char ch : s) {
            characterVsFrequencyMap.put(ch, characterVsFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        int deleteOperationCount = 0;
        HashSet<Integer> frequency = new HashSet<>();
        for (int currCharFrequency : characterVsFrequencyMap.values()) {
            while (currCharFrequency > 0 && frequency.contains(currCharFrequency)) {
                deleteOperationCount++;
                currCharFrequency--;
            }

            if (currCharFrequency > 0) {
                frequency.add(currCharFrequency);
            }
        }

        return deleteOperationCount;
    }

    private static int minDeletionsBySorting(String str) {
        char[] s = str.toCharArray();

        HashMap<Character, Integer> characterVsFrequencyMap = new HashMap<>();
        for (char ch : s) {
            characterVsFrequencyMap.put(ch, characterVsFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(characterVsFrequencyMap.values());

        int deleteOperationsCount = 0;
        int prevFrequency = Integer.MAX_VALUE;
        while (!maxHeap.isEmpty()) {
            int currDeleteOperations = 0;
            int currFrequency = maxHeap.poll();

            if (currFrequency >= prevFrequency) {
                if (prevFrequency == 0) {
                    currDeleteOperations = currFrequency; // remove all characters
                } else {
                    currDeleteOperations= currFrequency - prevFrequency + 1; // decrement frequency by 1
                }
            }

            currFrequency -= currDeleteOperations;
            deleteOperationsCount += currDeleteOperations;
            prevFrequency = currFrequency;
        }

        return deleteOperationsCount;
    }
}
