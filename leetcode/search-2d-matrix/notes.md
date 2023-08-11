Given following 2 properties of the matrix:
<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>
It can be concluded that if this matrix is converted into row-major 1D array, the resultant array would be sorted. Hence, binary search can be applied


<b>Calculating indices - </b>

e.g.:
<pre>
M    0   1   2
  +-----------+
0 | 1 | 2 | 3 |
  +-----------+
1 | 4 | 5 | 6 |
  +-----------+
</pre>

<pre>
A    0   1   2   3   4   5
    +-----------------------+
    | 1 | 2 | 3 | 4 | 5 | 6 |
    +-----------------------+
</pre>

num of rows in 2D array (m) = 2 <br>
num of cols in 2D array (n) = 3 (this is width of each row)


zeroth idx of 1D array = 0 <br>
last idx of 1D array = 5 = (2 * 3) - 1 = (m * n) - 1

In general,
<code>M[i][j] = A[i * j - 1] </code>


Equiv 2D index for given 1D index: <br>
A[3] = M[1][0] <br>
A[4] = M[1][1] <br>
A[1] = M[0][1] <br>

On observing it can be concluded that,
For any idx i in A, corresponding row in M will be i/width of row
and corresponding col will be i%width

Width of row is nothing but no. of cols, i.e., 'n'

Therefore, in general
<code>A[i] = M[i / n][i % n]</code>


Implement binary search for idx = 0 to (m * n) - 1, and to compare elements use (idx / n, idx % n)






