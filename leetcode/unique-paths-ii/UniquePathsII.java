import java.util.Arrays;
import java.util.Random;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0}, {0, 1}};

        int choice = Math.abs(new Random().nextInt() % 3);
        int result = switch (choice) {
            case 0 -> bottomUpDp(obstacleGrid);
            case 1 -> topDownDp(obstacleGrid);
            case 2 -> bottomUpSpaceOptDp(obstacleGrid);
            default -> 0;
        };

        System.out.println(result);
    }

    private static int topDownDp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dp(grid, 0, 0, dp);
    }

    private static int dp(int[][] grid, int currRow, int currCol, int[][] dp) {
        /* if out of bounds or blocked */
        if (currRow >= grid.length || currCol >= grid[0].length || grid[currRow][currCol] == 1) {
            return 0;
        }

        /* last cell */
        if (currRow == dp.length - 1 && currCol == dp[0].length - 1) {
            return 1;
        }

        if (dp[currRow][currCol] != -1) {
            return dp[currRow][currCol];
        }

        int ways = dp(grid, currRow + 1, currCol, dp);
        ways += dp(grid, currRow, currCol + 1, dp);

        return dp[currRow][currCol] = ways;
    }

    private static int bottomUpDp(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = grid[m][n] == 0 ? 1 : 0;

        for (int i = m - 1; i >= 0; i--) {
            if (grid[i][n] == 1) {
                /* if there's obstacle in any cell in any cell of last row, <br>
                then path from any cell before that cell will not lead to destination */
                break;
            }
            dp[i][n] = dp[i + 1][n];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (grid[m][i] == 1) {
                /* if there's obstacle in any cell in any cell of last col, <br>
                then path from any cell before that cell will not lead to destination */
                break;
            }
            dp[m][i] = dp[m][i + 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 1) { // if current cell is not blocked, then its right and bottom direction can be traversed
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

    private static int bottomUpSpaceOptDp(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        int[] dp = new int[n + 1];
        dp[n] = grid[m][n] == 0 ? 1 : 0;

        for (int i = n - 1; i >= 0; i--) {
            if (grid[m][i] != 1) {
                dp[i] = dp[i + 1];
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (j == n) {
                    dp[j] = grid[i][j] == 1 ? 0 : dp[j];
                } else {
                    dp[j] = grid[i][j] == 1 ? 0 : dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
