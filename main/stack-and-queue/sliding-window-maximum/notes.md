sliding window maximum:

##REVIEW AND FORMAT##


<br>In an array of size n, starting from 0, give maximum in windows of 0 to k, 1 to k + 1, ... n - k + 1 to n

<b>Number of windows</b>

Example:
<br><code>0 1 2 3 4 5 6 7 </code>

<pre>
if k = 1, w = 8 (== len)
</pre>

<pre>
if k = 2
0 1 2 3 4 5 6 7 
---
  ---
    ---
      ---
        ---
          ---
            ---
w = 7 (== len - 1)
</pre>

<pre>
if k = 3
0 1 2 3 4 5 6 7 
-----
  -----
    -----
      -----
        -----
          -----
w = 6 (== len - 2)
</pre>

<pre>
if k = 4
0 1 2 3 4 5 6 7 
-------
  -------
    -------
      -------
        -------
w = 5 (len - 3)
</pre>

In general,
<br><code>=> len - (k - 1)</code>

<hr>
<b>Using Priority Queue</b>
<br>1. Create a max heap
<br>2. Fill in first k elements of array in heap, top of heap will be max of first window
<br>3. For all subsequent windows, if index of heap top lies out of range of current window, poll
<br>4. Add current element to heap



Condition to check if idx is a part of current window:
0 1 2 3 4 5 6 7
k = 3
First window = 0 to 2
Therefore, anything before 0 wouldn't be a part of first window

(2 - 2) is current window, i.e., currIdx - (k - 1) is current window


Therefore, if polledIdx < currIdx - (k - 1), then it currIdx will be out of the window
polledIdx < currIdx - (k - 1)
currIdx - polledIdx < -(k + 1)
currIdx - polledIdx < 1 - k
currIdx - polledIdx > k - 1
OR currIdx - polledIdx >= k

Either of currIdx - polledIdx > k - 1 OR currIdx - polledIdx >= k condition will work

This will take more than O(nlogn) time because of

<hr>
<b>Using Monotonic Deque</b>
<br> This can be done in a linear time using dequeue
<br>
<br> [9,10,-7,9,-4,-8,2,-6], k = 5
<br> -------------


It'll be a monotonically decreasing queue
We'll keep adding elements, if they're lesser than queue's tail
If any element is greater than queue's tail, poll until queue is empty or any greater element in queue is found

Another time queue will be polled is to check whether queue head lies within current window or not


This algorithm will run 2*n times at max, therefore having O(n) time complexity

