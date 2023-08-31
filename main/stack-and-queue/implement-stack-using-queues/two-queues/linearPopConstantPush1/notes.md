<b>2 Queues - O(1) Push, O(n) Pop</b>
<br><b>Approach 1:</b>
<br>For push operation in constant time, element will be added simply to the end of the queue
<br>
<br>For pop operation, we require element from queue end
<br>
<br>To achieve this, we need to transfer queue.length - 1 elements to a temp queue
<br>Poll element at queue.length to return
<br>And swap reference pointers of main queue and temp queue as explained above
<br>
