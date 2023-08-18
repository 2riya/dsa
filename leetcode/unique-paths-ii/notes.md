<br> <b>Backtracking (Brute Force):</b>
<br> Intuitively, it can be solved using backtracking as we can start with one path and see if it leads to destination and then backtrack to check another path
<br> This will take exponential time, which will lead to time complexity
<br> 
<br> Time Complexity: 
<br> Rec Relation: T(n) = 2T(n - 1) + 1 => O(2^n)
<br> Shortcut: At each level, 2^level frames are created, therefore at nth level, 2^n frames will be there
<br> => T(n) = no. of frames * work done per frame = 2^n * 1 = 2^n
<br>
<br>
<br> <b>Note:</b> Upon drawing recursion tree, it could be observed that there were overlapping calls, therefore dp can be used
<br> Recursive call is driven by 2 parameters, col and row, i.e., 2D DP would be used
<br>
<hr>
<b>Top Down DP:</b>
<br><code>dp[i][j] = number of ways to reach destination starting from (i, j) cell</code>
<br>
<hr>
<b>Bottom Up DP:</b>
<br> For bottom up DP, it can be observed that, there's only one way to reach destination from last cell, i.e., 1
<br> So that would be initial state
<br> Since we are moving in right and bottom direction only, from the last row, we can just move right to reach destination if no obstacle is there, similar can be said for last column
<br> Therefore, pre-fill last row and last col
<br> Now, for each col since right and bottom direction can be traversed, <code>dp[i][j] = dp[i][j + 1] + dp[i + 1][j]</code>
<br> <code>dp[0][0]</code> would contain the final answer
<br>
<hr> <b>Bottom Up Space Optimized DP:</b>
<br> Space can also be optimized as at any point of time, we are using values from adjacent right cell and below cell
<br> Therefore, either dp of 2 rows can be used, or 1D array can be used as follows:
<br> <code>dp[i][j] = dp[i][j + 1] + d[i + 1][j]</code>
<br> <code>dp[i][j+1]</code> <- This will be the adjacent right cell of 1D array
<br> <code>d[i + 1][j]</code> <- This will be the already value present in <code>dp[i][j]</code> from previous iteration
<br> 
<br> So, in current iteration it can be updated as:
<br> <code>dp[i] = dp[i] + dp[i + 1]</code> // check code for proper conditions
