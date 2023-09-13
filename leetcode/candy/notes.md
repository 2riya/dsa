**O(n) TC, O(n) SC**

Given the condition, each student with higher ranking than its neighbor should have more number of candies
<br> First compute candies in terms of left neighbor
<br> Then compute in terms of right neighbor
<br> Maximize the number of candies obtained in each

<hr>

**O(n<sup>2</sup>) TC, O(n) SC**

In simple terms, if prev child has lesser rating than curr child
<br> Then current child will have 1 more candy than prev 

Also, if prev child has hgiher rating than curr child
<br> Then curr child should have minimum candies, i.e., 1

Until here, everything goes fine until we encounter a case like:
<br> 8 4 2 1 rankings
<br> 1 1 1 1 candies, if above approach is followed

Therefore, we'll tweak it to backtrack if curr child has lower ranking than prev child to ensure all prev children have more candies
<pre>
i = curr_child_idx
while(i > 0 && ratings[i] < ratings[i - 1]) {
    candies[i - 1] = max(candies[i - 1], candies[i] + 1)
}
</pre>


<hr>

### TODO: Complete

**O(n) TC, O(1) SC**

Sum of candies from left if ratings are in increasing order will be `1 + 2 + 3 + ... + n`
<br> And from right if candies are in decreasing order will be `m + ... + 3 + 2 + 1`


