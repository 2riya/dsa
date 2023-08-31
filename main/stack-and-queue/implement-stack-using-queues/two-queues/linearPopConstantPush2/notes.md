<b>2 Queues - O(1) Push, O(n) Pop</b>
<br>Similar thing can be achieved by maintaining 2 queues at class level - q1, q2
<br>
<br>Transfer (n - 1) elements to empty queue
<br>Element to be returned will be nth element
<br>
<br>
<br>Here, in both Approach 1 and 2, top will be declared at class level and will be updated during push and pop
<br>This will be done in order to achieve top() operation in constant time
<br>Otheriwse entire exercise similar to pop() operation will need to be repeated for top() also
