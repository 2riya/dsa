<h4>Hashing :: O(n) Space</h4>
Create a hashtable <code>ht</code> of size n
<br> Traverse input and fill in hashtable by incrementing <code>ht[input[i]] += 1</code>
<br> Traverse ht and for <code>A = i where ht[i] == 0</code> and <code>B = i where ht[i] == 2</code>

<hr>
<h4>Math :: O(1) Space</h4>

In the sequence of elements from 1 to n,
1. One of the elements occurs twice (say, A)
2. One of the elements is missing (say, B)

<pre>
Let's see sum of n natural numbers (say, Sn)
Let sum of given numbers be x

=> Sn = (1 + 2 + 3 + 4 + ..... + n) = x - A + B
=> Sn = x - A + B
=> A - B = x - Sn ------ (eqn 1)
</pre>

We now have one equation in terms of A and B,
<br>To solve 2 variables, we'd need one more equation

<pre>
Let's see sum of squares of first n natural numbers (say, SSn)
Let sum of squares of given numbers be y

=> SSn = (1^2 + 2^2 + 3^2 + .... + n^2) - A^2 + B^2
=> SSn = y - A^2 + B^2
=> A^2 - B^2 = y - SSn
=> (A - B) * (A + B) = y - SSn
=> (A + B) * (x - Sn) = y - SSn
=> (A + B) = (y - SSn)/(x - Sn)
</pre>

<pre>
Sn = (n * (n + 1)/2)
SSn = n * (n+1) * (2n+1) / 6 
</pre>
