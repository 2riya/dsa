### Binary Search

Given two arrays, a and b
<br>Where len(a) = m and len(b) = n

And both a and b are sorted in itself

Median is the central element of a sequence
<br>If sequence is even, there are two central elements and median is the average of the two central elements

Now if a has m elements and b has n elements
<br>Total elements will be m + n

If total elements are m + n, then we can partition them into two halves
<br>Where each half will contain (m+n)/2 elements

Let these two partitions be left (l) and right (r)

All elements in l should be lesser than equal to all elements in r

To ensure this,

Let l1 be the greatest element of a to exist in l
<br>and l2 be the greatest element of b to exist in l

Similarly, let r1 be the smallest element of a to exist in r
<br>and r2 be the smallest element of b to exist in r

Then l1 <= r1 will automatically satisfy as a is sorted
<br>and l2 <= r2 will also automatically satisfy as b is sorted

We need to ensure l1 <= r2 and l2 <= r1

In binary search, we will start with lo = 0 and hi = m
<br>First, we will take the mid number of elements from a in the left partition

This means the number of elements from b in the left partition will be (m + n)/2 - x

If we are not taking any element from any array, then int_min will be considered and if any element is not taken in the right array, int_max will be considered

Now, the median will be avg(max(l1, l2), min(r1, r2)) for even (m+n)

If (m+n) is odd, then the median will be min(r1, r2) as the right partition will contain an extra element

<hr>

### To review later:
How does taking first array of lesser length affect logic?
<br>Relevant TCs:
1. [1] []
2. [2,3,4,5] [1]
