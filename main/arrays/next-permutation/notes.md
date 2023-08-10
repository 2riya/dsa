Let's take example of words in dictionary

<pre>
abcd
abdc
acbd
acdb ....
</pre>

What we can observe is, <br>
It's increasing from backwards until a certain point <br>
And then starts decreasing <br>

<pre>
      d
    c 
  b   
a
 


    d
  b   c
a


    
  c   
a   b
      d

</pre>


<hr>

We can try to implement the same logic here.

**Example:**
<pre>
2 1 5 4 3 0 0
</pre>

Starting from right,

<pre>
2 1 5 4 3 0 0
          ---
          same digits only

2 1 5 4 3 0 0
        -----
2 1 5 4 0 3 0
2 1 5 4 0 0 3 
</pre>

Both of these perms are less than original perm


<pre>
2 1 5 4 3 0 0
      -------
2 1 5 4 0 3 0
2 1 5 4 0 0 3
2 1 5 0 4 3 0
2 1 5 0 0 4 3... and so on
</pre>

All these perms are also lesser than given permutation


<pre>
2 1 5 4 3 0 0
    ---------
2 1 4 5 3 0 0 
2 1 3 5 4 0 0
2 1 0 5 4 3 0
2 1 5 0 4 3 0... and so on
</pre>

All these perms are also lesser than given permutation


<pre>
2 1 5 4 3 0 0
  -----------
2 1 5 4 3 0 0
2 4 5 1 3 0 0
2 3 5 4 1 0 0
2 0 5 4 3 1 0... and so on
</pre>


Here, we can observe that a few permutations are greater than given permutation

_Why did this happen?_ <br>
From right to left, the numbers were in increasing order until 5 <br>
And changing any number until 5 would result in a sequence lesser than original <br>


At 1, the pattern got deviated and started decreasing <br>
Therefore, we got to choose amongst numbers greater than current digit <br>

Now to ensure, minimum possible increase, from this sequence of 5 to 0, we'll pick the number which is just greater than 1 <br>
If we pick number lesser than 1, it'll result into a smaller permutation <br>
If we pick any random greater number, then resultant permutation would be greater than original but wouldn't be just next greater


Therefore, we choose 3 and swap it with 1

<pre>
2 3 5 4 1 0 0
    ---------
</pre>

If we swap 1 and 3, sequence from 5 to 0 is still in decreasing order only <br>
I.e., this is the max possible number that can be obtained of digits from 5 to 0

Simply, the least possible number that can be obtained of these digits would be its reverse, i.e., these digits sorted in increasing order <br>

<pre>
2 3 0 0 1 4 5
--- ---------
</pre>
This is the next permutation of given permutation <br>


Steps involved: <br>
1. Find peak element <br>
2. Swap left(peak) with min(peak....perm[n]) <br>
3. Reverse(peak....perm[n]) <br>


<hr>
Algorithm: <a>https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order</a>
