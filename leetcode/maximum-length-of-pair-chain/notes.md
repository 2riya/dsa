<b>Monotonic Stack</b>
<br>Since pairs can be picked in any order, sort all pairs by 0th element
<br>
Starting with first pair in stack
<br>
<br>Pop out the pairs for which b > d, i.e., a pair with lesser right element exists, which can help in forming a longer subsequence
<br>
<br>Also, add pairs in stack only if b < c
<br>
<br>Whatever pairs are remaining in stack would form the longest increasing subsequence of pairs with condition b < c
<br>
<hr>

<b>LIS (DP) </b>
<br>This can be solved by using LIS also
<br>Sort all pairs by 0th index
<br>
<br>State of DP array: Each cell, dp[i], represents longest increasing subsequence of pairs till pairs[i]

<pre>
dp[0] = 1
for i <- 1 to n
	dp[i] = 1
	for j <- 0 to i - 1
		if pairs[i][1] < pairs[j][0]
			dp[i] = max(dp[i], dp[j] + 1)

	res = max(res, currLen)
</pre>

<hr>
