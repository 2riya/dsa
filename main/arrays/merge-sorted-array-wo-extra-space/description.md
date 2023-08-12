<h2>Merge Two Sorted Arrays Without Extra Space</h2>

<hr>
Given two non-decreasing sorted arrays, ‘A’ and ‘B’, having ‘N’ and ‘M’ elements, respectively. You must merge these arrays, ‘A’ and ‘B’, into a sorted array without using extra space. Of all the 'N + M' sorted elements, array 'A' should contain the first 'N' elements, and array 'B' should have the last 'M' elements.

<h4 id="note">Note:</h4>

<pre><code>You must perform the merge operation in place and must not allocate any extra space to merge the two arrays.
</code></pre>

<h4 id="for-example">For example:</h4>

<pre><code>When ‘N’ = 4, ‘A’ = {1, 4, 5, 7} and ‘M’ = 3, ‘B’ = {2, 3, 6}. 
We can merge these two arrays into {1, 2, 3, 4, 5, 6, 7} (The elements of ‘A’ are {1, 2, 3, 4} ).
Hence, the answer is {1, 2, 3, 4, 5, 6, 7}.
</code></pre>

<br>

<h5>Constraints:</h5>

<pre><code>1 &lt;= N &lt;= 10^5
1 &lt;= M &lt;= 10^5
0 &lt;= A[i] &lt;= 10^9
0 &lt;= B[i] &lt;= 10^9

The sum of ‘N + M’ over all test cases does not exceed 2 * 10^5.
Time Limit: 1-sec
</code></pre>
<br>
<h5>Example 1:</h5>
Input:
<pre><code>3 4
1 8 8
2 3 4 5
</code></pre>
Output:
<pre><code>1 2 3 4 5 8 8
</code></pre>
Explanation:
<pre><code>We have ‘A’ = {1, 8, 8} and ‘B’ = {2, 3, 4, 5}. 
Merging the two arrays results in {1, 2, 3, 4, 5, 8, 8}.
Hence the answer is {1, 2, 3, 4, 5, 8, 8}, where ‘A’ contains {1, 2, 3} and ‘B’ contains {4, 5, 8, 8}.
</code></pre>
<br>
<h5>Example 2:</h5>
Input:
<pre><code>4 5
1 1 1 1 
2 2 3 3 5
</code></pre>
Output:
<pre><code>1 1 1 1 2 2 3 3 5
</code></pre>
