**Approach 1: Nested Loops**

Taking examples,

Example: 1
<pre>
1   2  3  4   =>  13 9  5 1
5   6  7  8   =>  14 10 6 2
9  10 11 12   =>  15 11 7 3
13 14 15 16   =>  16 12 8 4
</pre>
<br>

Example: 2
<pre>
1 2 3      7 4 1
4 5 6   => 8 5 2
7 8 9      9 6 3
</pre>

In terms of indices,
<pre>
00 01 02     20 10 00 
10 11 12  => 21 11 01
20 21 22     22 12 02 
</pre>


It can be observed that: <br>
<pre>
1 replaces 3 -> 3 replaces 9 -> 9 replaces 7 -> 7 replaces 1
</pre>

In terms of indices,
<pre>
00 -> 02 -> 22 -> 20 -> 00
</pre>

<br>

Next movement is:
<pre>
2 replaces 6 -> 6 replaces 8 -> 8 replaces 4 -> 4 replaces 2
</pre>

In terms of indices,
<pre>
01 -> 12 -> 21 -> 10 -> 01
</pre>

<br>


It can be generalized in terms of indices as,
<pre>
i,j -> j,(n-i) -> (n-i)m(n-j) -> (n-j),i -> i,j
</pre>

Also, the movement happens in concentric circles starting from corner. Therefore,
<pre>
for each i = 0 to n/2
	for j = i to (n - i)
</pre>

<br>
Pseudocode:
<pre>
for each i = 0 to n/2   // O(n)
	for j = i to (n - i) // O(n)
        i,j -> j,(n-i) -> (n-i)m(n-j) -> (n-j),i -> i,j // O(4)
</pre>
<br>
=> T.C. = O(n^2), S.C. = O(1)

<br>
<br>

<hr>

**Approach 2: Transpose and Reverse**
<br>

Example:
<pre>
1 2 3      7 4 1
4 5 6   => 8 5 2
7 8 9      9 6 3
</pre>

<br>
Another observation is, first row elements are all last col elements. Second row is second last col, and so on till the last row that becomes the first col.
<pre>
1 2 3 => 1    1 2 3     4 1    1 2 3    7 4 1 
         2    4 5 6  => 5 2    4 5 6 => 8 5 2 
         3              6 3    7 8 9    9 6 3
</pre>

Revisiting the concept of transpose of a matrix, where all rows are converted into cols, such that first row becomes first col and last row becomes last col.<br>
We can take a transponse of the matrix and see if we can generate our rotated matrix from it:
<pre>
1 2 3      1 4 7
4 5 6   => 2 5 8
7 8 9      3 6 9
</pre>
Here, if we simply reverse each row of transpose matrix, we'll get resultant rotated matrix
<pre>
1 2 3      7 4 1
4 5 6   => 8 5 2
7 8 9      9 6 3
</pre>

<br>

_Transpose Implementation:_
<br>
Converting each row into col requires following change in indices -
<pre>
00 01 02 03 => 00 10 20 30
10 11 12 13 => 01 11 21 31
20 21 22 23 => 02 12 22 32
30 31 32 33 => 03 13 23 33
</pre>

In general, following swaps will happen
<pre>
ij -> ji
</pre>
<br>
Since the swaps are happening for each row with each col, loop will run in following fashion
<pre>
00 01 02 03      00 10 20 30      00 10 20 30      00 10 20 30
10           =>  01 11 21 31  =>  01 11 21 31  =>  01 11 21 31
20               02 12            02 12 22 32      02 12 22 32 
30               03 13            03 13 23         03 13 23 33
</pre>
Therefore, loop will run as
<pre>
for i = 0 to n
    for j = i to n
</pre>
