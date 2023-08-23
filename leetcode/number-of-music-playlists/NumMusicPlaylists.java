import java.util.Arrays;
import java.util.Random;

public class NumMusicPlaylists {
    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        int n = 30;
        int goal = 34;
        int k = 4;

        System.out.println(numMusicPlaylists(n, goal, k));

        n = 2;
        goal = 3;
        k = 0;

        System.out.println(numMusicPlaylists(n, goal, k));
    }

    private static int numMusicPlaylists(int n, int goal, int k) {
        int flag = new Random().nextInt() % 2;

        if (flag == 0) {
            return bottomUpDp(n, goal, k);
        }
        return topDownDp(n, goal, k);
    }

    private static int topDownDp(int n, int goal, int k) {
        long[][] dp = new long[101][101];

        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }

        return (int) dp(0, 0, goal, n, k, dp);
    }

    private static long dp(int playListCurrLen, int songsUsed, int goal, int n, int k,
        long[][] dp) {
        if (playListCurrLen == goal) {
            return songsUsed == n ? 1 : 0;
        }

        if (dp[playListCurrLen][songsUsed] != -1) {
            return dp[playListCurrLen][songsUsed];
        }

        long chooseFromExisting =
            (Math.max(0, songsUsed - k) * dp(playListCurrLen + 1, songsUsed, goal, n, k, dp)) % MOD;
        long chooseNewSong =
            ((n - songsUsed) * dp(playListCurrLen + 1, songsUsed + 1, goal, n, k, dp)) % MOD;

        long total = (chooseFromExisting + chooseNewSong) % MOD;

        return dp[playListCurrLen][songsUsed] = (total % MOD);
    }


    /* Implemented this by simply replicating recursion calls of top down dp */
    private static int bottomUpDp(int n, int goal, int k) {
        long[][] dp = new long[101][101];

        dp[0][0] = 1;

        for (int playListCurrLen = 1; playListCurrLen <= goal; playListCurrLen++) {
            for (int songsUsed = 1; songsUsed <= n; songsUsed++) {
                long chooseNewSong =
                    (dp[playListCurrLen - 1][songsUsed - 1] * (n - (songsUsed - 1))) % MOD;
                long chooseFromExisting =
                    (dp[playListCurrLen - 1][songsUsed] * Math.max(0, songsUsed - k)) % MOD;

                dp[playListCurrLen][songsUsed] += (chooseFromExisting + chooseNewSong) % MOD;
            }
        }

        return (int) dp[goal][n];
    }


    /**
     Reference:
     https://leetcode.com/problems/number-of-music-playlists/solutions/1637225/recursive-definition-with-detailed-explanation/
     https://www.youtube.com/watch?v=uvjn6UDXVrY
     https://www.youtube.com/watch?v=xRqkSe5pPSw
     */
}
