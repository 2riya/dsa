Two ways to think of it -
1. For each coin, choose whether to include it or exclude it in current call
2. Starting with the first coin, for each coin c, keep adding that c until amt is reached or exceeded. If amt is reached, valid comb, else remove one c and check with (c + 1)th coin

<hr>

**Approach 1:**

**Recursive:**
<pre>
if (curr >= coin.length || amt < 0) 
	return 0

if (amt == 0) 
	return 1


// include coin
result += f(amt - coins[currCoin], currCoin)

// exclude coin
result += f(amt, currCoin + 1)
</pre>

<pre>
								f(5,0)
			f(4,0)								f (5,1)		
	f(3,0)			f(4,1)				f(3,1)			f(5,2)
f(2,0)	f(3,1)	f(2,1)	f(4,2)		f(2,1)	f(3,2)	f(0,2)	 xx (as 2 is the last index)

</pre>


We can see overlapping calls, e.g.: f(3,1)
There, 2D DP can be used on remaining amt, curr coin

dp[i][j] -> Represents ways of making up 'i' amount using first 'j' coins

<br>
<b> Top Down DP </b>
<br>Since 0 is a valid answer, fill DP table with -1
<pre>
if (curr >= coin.length || amt < 0) 
	return 0

if (amt == 0) 
	return 1

if (dp[amt][currCoin] != -1)
	return dp[amt][currCoin]


// include coin
result += f(amt - coins[currCoin], currCoin)

// exclude coin
result += f(amt, currCoin + 1)

dp[amt][currCoin] = result
</pre>


<b> Bottom Up DP </b>

<pre>
dp[amt + 1][coins.length + 1]

for (remAmt = 0 to amt)
for (coin = 0 to n) {
	
	dp[remAmt][coin] = dp[remAmt][currCoin - 1] // a

	if (remAmt >= coins[currCoin]) {
		dp[remAmt][coin] = dp[remAmt - coins[currCoin]][currCoin - 1] // b
	}
}

result = dp[amt][coins.length]
</pre>

**Space Optimization:**
<br>
<br>From a and b, it can be observed that only prev coin is being used
<br>Therefore, instead of storing entire DP array, we can just store prev and build curr on the basis of it
<br> _Dry ran it for example coins=[1,2,5] and amount=5_
<br>
<br>To implement it, prev and outer loops need to be swapped
<br>Because traversal is being done row-wise
<br>So each col will be required for a given row's iteration, and hence keeping only 2 cols won't give correct ans
<br>As it'd keep on overriding values which would be required
<br>
<br>Instead, loop from coin 0th to nth, and for each coin for remAmt 0 to amount
<br>This way, all prev coin data that a current coin needs would be present

<hr>

**Approach 2:**

**Recursive:**
<pre>
f (curr, amt) {
	if (amt < 0) 
		return 0

	if (amt == 0) 
		return 1

	res = 0
	for (int i = curr to coins.length)
		res += f(amt - coins[i], i)	
}
</pre>

**Top Down DP**
<pre>
f (amt, currCoin) {
	if (amt < 0) 
		return 0

	if (amt == 0) 
		return 1

	if (dp[amt][currCoin] != -1)
		return dp[amt][currCoin]

	res = 0
	for (int i = curr to coins.length)
		res += f(amt - coins[i], i)	

	dp[amt][currCoin] = res
}
</pre>


<br>Bottom up approach is similar to prev one, explained in code with comments





