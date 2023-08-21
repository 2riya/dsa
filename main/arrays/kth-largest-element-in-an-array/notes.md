<h3>Sorting</h3>
1. Sort the array // O(nlogn)
2. Return (k-1)th element

<hr>
<h3>Quick Select</h3>
Similar to quick sort (descending order)
<br>Only difference is, instead of calling quickSort recursively twice
<br>Call only for the half which includes (k - 1)th index

<pre>
pIdx = partition(l, r, nums);
            
if (pIdx == k - 1) :
    result = pIdx 	// partitioned at k
else if (res < k - 1) :
    l = pIdx + 1; 	// k lies in right half
else :
    r = pIdx - 1; 	// k lies in left half
</pre>

Note: Pivots of any particular index might give TLE, therefore use randomized pivots


<hr>
<h3>Priority Queue</h3>

Why min heap?
<br>For a min heap of size x, since top stores the smallest element, it will be xth greatest element

<br>Why polling at <code>size == k</code> won't work?
<br>At any given point of time, min heap's top will contain xth smallest element
<br>If min heap is polled before adding any other element, it will contain <code>x - 1</code> elements and xth greatest element will be popped out

To avoid this, do any of the following:
<br>1. Poll when <code>size == x + 1</code>
<br>2. Poll at <code>size == x</code>, only if <code>currElement > minHeap.peek()</code>
