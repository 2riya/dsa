
Note:
1. Queue is FIFO
2. Ordering of queue is maintained when elements are transferred from one queue to another, i.e.,
   Q1 [1, 2, 3, 4, 5]  ->  Q2 [1, 2, 3, 4, 5]

<hr> 
<b>2 Queues - O(n) Push, O(1) Pop</b>
<br><b>Approach 1:</b>
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
<br><b>Approach 2:</b>
<br>Maintain 2 queues at class level - q1, q2
<br>One queue will always be empty at any given point of time and that queue will act as temp queue to tranfer contents during push operation
<br>
<br>Diff - 
<br>Swap operation isn't required
<br>Additional if empty queue check on pop and top operations
<br>
<br>
<hr>
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
<br>
<br><b>Approach 2:</b>
<br>Similar thing can be achieved by maintaining 2 queues at class level - q1, q2
<br>
<br>Transfer (n - 1) elements to empty queue
<br>Element to be returned will be nth element
<br>
<br>
<br>Here, in both Approach 1 and 2, top will be declared at class level and will be updated during push and pop
<br>This will be done in order to achieve top() operation in constant time
<br>Otheriwse entire exercise similar to pop() operation will need to be repeated for top() also

<hr>
<b>1 Queue - O(n) Push, O(1) Pop</b>
<br>Instead of adding to a temp queue
<br>Poll elements from beginning of the queue and add it to the end everytime a new element is inserted
<br>This way, top of queue will always point at new element
<br>
<br>
<br>Initially, Q [a, b, c]
<br>New element = x
<br>
<br>Add x to Q [a, b, c, x]
<br>
<br>Poll (n - 1) elements from Q and add it to Q again
<br>
<br>[b, c, x, a]
<br>[c, x, a, b]
<br>[x, a, b, c]
<br>
<br>'x' is head of queue.

<hr>
<b>1 Queue - O(1) Push, O(n) Pop</b>
<br>Pop operation can be modified to:
<br>Poll (n - 1) elements and add it to the end of queue
<br>Return nth element
