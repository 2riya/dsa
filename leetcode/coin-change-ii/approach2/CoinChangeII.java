package approach2;

import java.util.Arrays;
import java.util.Random;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 500;
        int[] coins = new int[] {3, 5, 7, 8, 9, 10, 11};

        int choice = Math.abs(new Random().nextInt() % 2);
        int result = switch (choice) {
            case 0 -> bottomUpDp(amount, coins);
            case 1 -> topDownDp(amount, coins);
            default -> 0;
        };

        System.out.println(result);
    }

    private static int bottomUpDp(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];

        Arrays.fill(dp[0],
            1); // Ways of making up 0, with any combination of coins will always be 1

        for (int remAmt = 1; remAmt <= amount; remAmt++) { // Loop to implement recursive calls
            for (int currCoin = 1; currCoin <= coins.length; currCoin++) {  // Loop inside recursive function

                /* Base Case 1, as 0 is added to previously obtained result
                If coin sum is greater, i.e., amt goes into negative */
                dp[remAmt][currCoin] = dp[remAmt][currCoin - 1];

                if (remAmt >= coins[currCoin - 1]) { // If base case 2 is satisfied, add recursive call result
                    dp[remAmt][currCoin] +=
                        dp[remAmt - coins[currCoin - 1]][currCoin]; // Recursive call
                }
            }
        }

        return dp[amount][coins.length];
    }

    private static int topDownDp(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return rec(amount, coins, 0, dp);
    }

    private static int rec(int remAmt, int[] coins, int curr, int[][] dp) {
        if (remAmt < 0) { // Base Case 1, coin is skipped
            return 0;
        }

        if (remAmt == 0) { // Base Case 2, coin is added & final amt reached
            return 1;
        }

        if (dp[remAmt][curr] != -1) {
            return dp[remAmt][curr];
        }

        int res = 0;
        for (int i = curr; i < coins.length; i++) {
            res += rec(remAmt - coins[i], coins, i, dp);
        }

        return dp[remAmt][curr] = res;
    }
}
