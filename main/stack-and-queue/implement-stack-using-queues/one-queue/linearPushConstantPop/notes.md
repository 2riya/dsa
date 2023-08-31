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
