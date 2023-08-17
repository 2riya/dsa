Given that -
<br> Each element can form a pair with either its right element or left element
<br> Each element can be used only once in a pair

<b>Why won't Single Pass work?</b>
<br> Intuitively, it can be thought of implementing in a single pass, checking whether an element should form pair with its adjacent right element or adjacent left element.
<br> But if we form pair with right element, considering it to be most favourable for current element and move forward, we might skip checking the best possibility for right element.
<br> And hence, it would lead to incorrect result.
<br>
<br> It can be explained with the help of an example as follows:
<pre>
idx:  0 1 2 3 4 5
arr: [1 2 2 2 3 3]
</pre>
<br>
Let's start from i = 0, and compare diff of each index with its right and left element and maintain diff in an array for lookups
<br>
<br> i = 0 -> arr[1] - arr[0] = 1 -> diff: [1]
<br>
<br> i = 1 -> arr[2] - arr[1] = 0 and arr[1] - arr[0] = 1
<br> Between both of these, adding pair(1, 2) seems better
<br> Therefore, we'll discard previous pair and include arr[1] in this pair
<br> diff: [inf, 0]
<br>
<br> i = 2 -> leftDiff = 0 and rightDiff = 0 
<br> Since left element is already included in a pair with same diff, we won't add anything for this element
<br> diff: [inf, 0, inf]
<br>
<br> i = 3 -> leftDiff = 0 and rightDiff = 1
<br> Since left element is already being consumed, we won't consider left difference and add right difference to array
<br> diff: [inf, 0, inf, 1]
<br> 
<br> i = 4 -> leftDiff = 1 and rightDiff = 0
<br> Since this element was being used for prev diff, which is greater than rightDiff, take this element out from that pair and pair it along with its right element
<br> diff: [inf, 0, inf, inf, 0]
<br>
<br> Using above approach, we were able to generate 2 pairs with 0 difference
<br> Whereas for above input, there are 2 pairs with diff 0 and 1 pair with diff 1
<pre>
idx:  0 1 2 3 4 5
arr: [1 2 2 2 3 3]
      --- --- ---
       1   0   0
</pre>
<br> 
<b>Binary Search:</b>
<br> Instead we can use binary search for each difference 'd' and calculate number of pairs having havinf difference <= d.
<br> If more than or equal number of such pairs are there, we'll search for a lesser difference, i.e., low = mid - 1, else we'll search for a higher difference, i.e., hi = mid + 1
<br> We'll just compare curr element with next element to check for difference and if it forms a valid pair, resume iteration from next to next element, otherwise resume from next element
<pre>
 0 1 2
[2 2 2]  diff = 0

i = 0 -> a[1] - a[0] = 0 -> valid pair -> i += 2
i = 2 -> no next element exists, therefore stop iteration
Hence, one pair with diff 0
</pre>
