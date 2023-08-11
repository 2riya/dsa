package approach1;

import java.util.Arrays;
import java.util.Random;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 5;

        int choice = Math.abs(new Random().nextInt() % 4);
        int result = switch (choice) {
            case 0 -> rec(0, amount, coins);
            case 1 -> bottomUpDp(amount, coins);
            case 2 -> bottomUpReversedLoop(amount, coins);
            case 3 -> spaceOptimizedBottomUp(amount, coins);
            default -> 0;
        };

        System.out.println(result);
    }

    private static int rec(int currCoin, int remAmt, int[] coins) {
        if (currCoin >= coins.length || remAmt < 0) {
            return 0;
        }

        if (remAmt == 0) {
            return 1;
        }

        // include current coin
        int res = rec(currCoin, remAmt - coins[currCoin], coins);

        // exclude current coin
        res += rec(currCoin + 1, remAmt, coins);

        return res;
    }

    private static int bottomUpDp(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];

        Arrays.fill(dp[0],
            1); // Ways of making up 0, with any combination of coins will always be 1

        for (int remAmt = 1; remAmt <= amount; remAmt++) {
            for (int currCoin = 1; currCoin <= coins.length; currCoin++) {

                dp[remAmt][currCoin] = dp[remAmt][currCoin - 1];

                if (remAmt >= coins[currCoin - 1]) {
                    dp[remAmt][currCoin] += dp[remAmt - coins[currCoin - 1]][currCoin];
                }
            }
        }

        return dp[amount][coins.length];
    }

    private static int bottomUpReversedLoop(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int currCoin = 1; currCoin <= coins.length; currCoin++) {
            int currRow = currCoin;
            int prevRow = currCoin - 1;

            for (int remAmt = 1; remAmt <= amount; remAmt++) {
                dp[currRow][remAmt] = dp[prevRow][remAmt];

                if (remAmt >= coins[currCoin - 1]) {
                    dp[currRow][remAmt] += dp[currRow][remAmt - coins[currCoin - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    private static int spaceOptimizedBottomUp(int amount, int[] coins) {
        int[][] dp = new int[2][amount + 1];

        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int currCoin = 1; currCoin <= coins.length; currCoin++) {
            int currRow = currCoin % 2;
            int prevRow = (currCoin - 1) % 2;

            for (int remAmt = 1; remAmt <= amount; remAmt++) {
                dp[currRow][remAmt] = dp[prevRow][remAmt];

                if (remAmt >= coins[currCoin - 1]) {
                    dp[currRow][remAmt] += dp[currRow][remAmt - coins[currCoin - 1]];
                }
            }
        }

        return dp[coins.length % 2][amount];
    }
}
