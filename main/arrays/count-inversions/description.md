<a href="https://www.codingninjas.com/studio/problems/count-inversions_615"><h2>Count Inversions</h2></a>
An inversion is defined for a pair of integers in the array/list when the following two conditions are met.

<pre><code>A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] &gt; 'ARR[j]' 
2. 'i' &lt; 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').
</code></pre>

<h5 id="note">Input Format:</h5>
<pre><code>The first line of input contains an integer 'N', denoting the size of the array.

The second line of input contains 'N' integers separated by a single space, denoting the elements of the array 'ARR'.
</code></pre>

<h5 id="output-format">Output format :</h5>

<pre><code>Print a single line containing a single integer that denotes the total count of inversions in the input array.
</code></pre>

<h5 id="note">Note:</h5>

<pre><code>You are not required to print anything, it has been already taken care of. Just implement the given function.  
</code></pre></div></div><!----><div _ngcontent-serverapp-c161="" disableselect="" class="description pt-8 prevent-select ng-star-inserted"><h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= N &lt;= 10^5 
1 &lt;= ARR[i] &lt;= 10^9

Where 'ARR[i]' denotes the array element at 'ith' index.

Time Limit: 1 sec
</code></pre></div><div _ngcontent-serverapp-c161="" class="description mt-24 ng-star-inserted"><h5>Sample Input 1 :</h5>

<pre><code>3
3 2 1
</code></pre>

<h5>Sample Output 1 :</h5>

<pre><code>3
</code></pre>

<h5>Explanation of Sample Output 1:</h5>

<pre><code>We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
</code></pre>

<h5>Sample Input 2 :</h5>

<pre><code>5
2 5 1 3 4
</code></pre>

<h5>Sample Output 2 :</h5>

<pre><code>4
</code></pre>

<h5>Explanation of Sample Output 1:</h5>

<pre><code>We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).
</code></pre>
</div><!----><!----><!----></div>
