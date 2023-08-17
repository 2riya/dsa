Input: [[1,5], [2,3], [8,10], [5,7], [15,18]]
<br>Output: [[1,7], [8,10], [15,18]]

<br> Sort all intervals on the basis of first index
<br> Two intervals <code>i1 = [a, b]</code>, <code>i2 = [c, d]</code>  will be merged if <code>b >= c</code>
<br> New interval will be <code>[a, max(b, d)]</code>
<br>
<br> Add first interval to result and for each of remaining intervals,
<br> Check if it can be merged with prev interval
<br> If yes, create a new interval by merging, remove already existing interval and add new interval to result
