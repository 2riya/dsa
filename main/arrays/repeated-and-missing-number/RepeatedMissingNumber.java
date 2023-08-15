import java.util.List;

public class RepeatedMissingNumber {
    public static void main(String[] args) {
        List<Integer> input = List.of(5, 6, 3, 4, 1, 2, 2);
        missingAndRepeating(input, input.size());
    }

    private static int[] missingAndRepeating(List<Integer> arr, int n) {
        long x = arr.stream().mapToLong(a -> a).sum();
        long y = arr.stream().mapToLong(a -> (long) a * a).sum();

        long sum = ((long) (n + 1) * n) / 2L;
        long sumSquares = (n * (n + 1) * (2L * n + 1)) / 6L;

        long abDiff = x - sum; // eqn1
        long abSum = (y - sumSquares) / abDiff; // eqn2

        long A = (abDiff + abSum) / 2;
        long B = abSum - A;

        return new int[] {(int) B, (int) A};
    }
}
