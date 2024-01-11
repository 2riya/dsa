Problem:
<br>We have to see that each number x between 1 to target can be formed by summing up a subsequence of nums
<br>If not, then add an element to array such that every number between 1 to x is obtainable

Also, minimize the number of elements to be added

Approach:
<br>We have to check for each x from 1 to target

So starting from x = 1 and the very first element of nums (sorted in ascending order), if x cannot be formed, this means we will need to add an element

Two things to note if an element is added,
1. The element we will add will be `x` because we couldn't find that in nums
2. If we add `x` to nums, it means that we had already checked for all elements in the range of `1` to `x - 1`, which means adding `x` now will result into formation of all elements in the range of x, x + 1, .... , (x + x - 1) = 2x - 1. Hence, `now check for 2x`


Now, regardless of whether a number was added or not
<br>If x == num, or x > num
<br>Since we are incrementally checking for x, it means all 1 to x - 1, we would have checked already and then reached to x
<br>So 1 + num, 2 + num, ... , x - 1 + num, can also be formed
<br>Therefore, `update x to x + num`

While updating `x` if target is reached, we can return with the number of patches
<br>Else we can keep checking for available elements of nums and patching array 
