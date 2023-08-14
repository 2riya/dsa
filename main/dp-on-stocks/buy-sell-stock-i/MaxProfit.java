public class MaxProfit {
    public static void main(String[] args) {
        int[] input = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int todaysPrice : prices) {
            buy = Math.min(buy, todaysPrice);
            maxProfit = Math.max(maxProfit, todaysPrice - buy);
        }

        return maxProfit;
    }
}
