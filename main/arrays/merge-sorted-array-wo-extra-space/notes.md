<b>Brute Force:</b>
<br> Take an array C of size M+N
<br> Put i on A's zeroth element and j on B's zeroth element
<br> Start filling in from i or j, whichever is lesser, add and increment that pointer
<br> Once filling of C array is done, put a pointer k on C's zeorth element and put first M elements of C in A and M+1 to N elements in B
<br>
<br>T.C. = O(M + N)
<br>S.C. = O(M + N)
<br>
<br>
<hr>
<b>Constant Space Complexity:</b>
<br> A should contain first M elements and B should contain M+1 to N elements
<br> Let's move any element in B which is amongst the first M smallest elements to A
<br> In this process, move any element which lies in the range of M+1 to N sorted elements to B
<br> Once this is done, A and B will contain all the elements that should be part of them, but possibly in unsorted sequence
<br> Sort both A and B separately
<br>
<br>T.C. = O(M + N)
<br>S.C. = O(1)
