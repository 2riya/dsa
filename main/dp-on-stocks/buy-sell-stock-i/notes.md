<h4>O(n^2) Time Complexity:</h4>
For each day, try buying today and try selling next day to nth day
<br> Maximize the diff obtained
<pre>
profit = INT_MIN
for i <- 0 to n - 1
    for j <- i + 1 to n
        curr_diff = a[j] - a[i]
        profit = Math.max(profit, curr_diff)
</pre>

<hr>
<h4>O(n) Time Complexity:</h4>
Why will finding min and max value and subtracting them not work?

<code>7 1 5 3 6 4</code>
<br> min = 1
<br> max = 7
<br> diff = 7 - 1 = 6
<br> But 7 was price before one, and stock should be bought before selling
<br> Therefore, above ans is incorrect

<br> Given that we buy first and then cell, and can buy only once and sell only once
<br> Therefore, we'll buy on the minimal possible price and selling on the greatest price after that
<pre>
buy = a[0]
for i <- 1 to n
    buy = min(buy, a[i])
    profit = max(profit, a[i] - buy)
</pre>
