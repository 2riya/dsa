**Intuition:** <br>
Elements need to be added to the first array since it has extra space in the end

If we start adding elements from the beginning, it might overlap the existing elements of first array
<br>Therefore, we can think of adding it from the end, as there are all zeroes there

To add from the end, since both the arrays are sorted, decreasing order will be maintained, i.e., whatever between end(a) and end(b) would be greater would be the last element of resultant array

Therefore, we can start from end of a (m) and end of b (n) to compare elements and start filling elements from (m+n)
