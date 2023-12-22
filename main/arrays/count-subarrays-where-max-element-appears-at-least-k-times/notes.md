
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.


After finding the max element (say max),
<br>Need to maintain a sliding window, where `max` occurs `k` times

Number of subarrays formed due the current window will be whatever length of array is remaining towards the right (because at least `k` times we want the element, if remaining elements contain `max` or not, it would still form a valid subarray)



```
1 3 2 3 3
-------
first window -> no. of subarrays will be 2 (len - rightPointerIdx)

now increment the left pointer to as to find other subarrays or a new window
1 3 2 3 3
  -----
second window -> no. of subarrays will be 2 (len - rightPointerIdx)

increment left pointer again
1 3 2 3 3
---
this is not a valid window as count(max) < k, therefore increment right pointer


1 3 2 3 3
-----
third window -> no. of subarrays will be 1 (len - rightPointerIdx)

increment left pointer again
1 3 2 3 3
---
fourth window -> no. of subarrays will be 1 (len - rightPointerIdx)


total subarrays = first window + second + third + fourth
= 2 + 2 + 1 + 1
= 6

