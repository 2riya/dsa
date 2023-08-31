<b>2 Queues - O(n) Push, O(1) Pop</b>
<br>For a new element (say, x), this should be the first element of the main queue, if needs to be popped in constant time
<br>
<br>To achieve that, whenever push is called, create a temp queue
<br>Insert x to it
<br>Now, 'x' is the first element of temp queue
<br>
<br>Now transfer all elements of main queue to temp queue
<br>
<br>If main queue initially was [a, b, c...]
<br>Then temp queue now looks like [x, a, b, c]
<br>
<br>Now using a tempRefPointer, swap the references of main queue and temp queue
<br>This needs to be done as for other operations, main queue only needs to be used
<br>
<br>Swap takes O(1) time, which saves us from 2*n operations of transferring contents from temp queue back to main queue
<br>
<br>
