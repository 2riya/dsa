Intuitively, it can be thought of as:
<br>If 'x' amount is poured into first glass
<br>Then x/2 will be poured into next row
<br>And x/2*2 into next to next row and so on

One thing to note is that, when a glass overflows, the next glasses will receive (x-1)/2
<br> Because current glass will consume 1unit of water

**Algorithm:**
1. First row will have 'x' amount of water
2. Subsequent rows will have 'x-1'/2 amount of water
3. Also, for a glass (i, j), i -> row of class and j -> number of glass in that row
<br> Glass will receive champagne from previous two glasses, i.e., (i-1, j-1) and (i-1, j)
4. Points to note:
   1. While doing x - 1, if current glass champagne becomes negative, consider 0
   2. If x is greater than champagne in (query_row, query_glass), return 1, as the remaining will overflow

**Time Complexity:**
<br>query_rows -> for outer loop
<br>query_rows -> for inner loop
<br>=> O(query_rows<sup>2</sup>)
