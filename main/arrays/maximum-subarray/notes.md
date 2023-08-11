<pre>
-2 1 -3 4 -1 2 1 -5 4
--
----
-------
</pre>

Subarray is contiguous block of array
Start taking subarray from idx = 0
<pre>
-2 
-2 1 
-2 1 -3 
1 
1 -3 ...
</pre>
All these are subarrays


Run nested for loops for generating a subarray and compute sum for each subarray
Find the maximum sum from all these subarrays generated

<pre>
for (int i = 0; i < n; i++) {
	for (int j = i; j < n; j++) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += a[k];
		}
		result = Math.max(result, sum);
	}
}
</pre>
<b>T.C. = O(n^3)</b>

<pre>
for (int i = 0; i < n; i++) {
	for (int j = i; j < n; j++) {
		int sum = 0;
		for (int k = i; k <= j; k++) { // This loop is repeatedly calculating sum from i to j-1, instead we can that sum and simply add next element
			sum += a[k];
		}
		result = Math.max(result, sum);
	}
}
</pre>
<pre>
for (int i = 0; i < n; i++) {
	int sum = 0;
	for (int j = i; j < n; j++) {
		sum += a[j];
		result = Math.max(result, sum);
	}
}
</pre>
<b>T.C. = O(n^2)</b>


<hr>


<h4>Kadane's Algorithm</h4>

Example:
<pre>
-2 1 -3 4 -1 2 1 -5 4
</pre>

Initially, <code>result = inf</code>
Start summing from i = 0 to n

<pre>
i = 0 -> sum = -2 , result = max(result, sum) = -2
</pre>

Now, if we add -2 to any other number, it'll simply decrement the overall sum
Therefore, we'll discard this, and start looking for some other subarray

<pre>
sum = 0
i = 1 -> sum = 1 , result = max(result, sum) = 1
</pre>
Since 1 is positive, if it's adding to anything, it'll increment the overall sum

<pre>
i = 2 -> sum = -2 , result = max(result, sum) = 1
</pre>
Since sum is again negative, discard the array until here and make sum = 0

<pre>
i = 3 -> sum = 4 , result = 4
</pre>
<pre>
i = 4 -> sum = 3 , result = 4
</pre>
Although the sum decreased here, it's still positive, and if added to anything, it'll increase the overall sum, so no need to discard this value

<pre>
i = 5 -> sum = 5 , result = 5
</pre>
<pre>
i = 6 -> sum = 6 , result = 6
</pre>
<pre>
i = 7 -> sum = 1 , result = 6
</pre>
<pre>
i = 8 -> sum = 5 , result = 6
</pre>

Hence, max subarray sum is 6


<br>If we need to find what subarray consituted to the max sum, we can observe that whenever sum was 0, we started a new subarray
<br>So, starting idx of subarray would change whenever sum becomes 0
<br>Also, ending is marked whenever sum so far becomes greater than result. So end will be at this idx
<br>

Pseudocode that includes this:
<pre>
for i <- 0 to n {
	if sum == 0 { // this is done here because sum would have become 0 is prev iteration, and next idx after sum became 0 would mark the start of new array
		start = i
	}

	sum += a[i]

	if (sum > max) {
		max = sum
		ansStartIdx = start
		ansEndIdx = end
	}

	if (sum < 0) {
		sum = 0;
	}
}
</pre>






