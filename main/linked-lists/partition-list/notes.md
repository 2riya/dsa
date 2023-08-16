<code>head = [1,4,3,2,5,2], x = 3 </code>

Two rules:
1. All elements lesser than 'x' should come before elements greater than equal to 'x'
2. Relative ordering of elements should be maintained

Note: It's not necessary that all elements greater than 'x' should be present on right

<br>
<b>Implementation:</b>
<br>1. Traverse over existing linked list and create two linked lists - left and right
<br>2. Left will contain all elements lesser than x and right will contain all elements greater than equal to x
<br>3. Join both the linked lists

<pre>
left = new dummy node
right = new dummy node

leftPtr = left
rightPtr = right

while (p != null) 
	if p.val < x
		leftPtr.next = new node(p.val)
		leftPtr = leftPtr.next
	else 
		rightPtr.next = new node(p.val)
		rightPtr = rightPtr.next


leftPtr.next = right.next

return left.next
</pre>

<hr>
<b>Without creating new nodes:</b>
<br>leftHead = new dummy node
<br>rightHead = new dummy node

<br>leftPtr = leftHead
<br>rightPtr = rightHead

<br>head = 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3

<pre>
1 < 3
leftPtr.next = head 
					leftHead = dummyNode -> 1 -> 4 -> 3 -> 2 -> 5 -> 2
leftPtr = leftPtr.next 
					leftPtr = 1 -> 4 -> 3 -> 2 -> 5 -> 2

head = head.next 
					head = 4 -> 3 -> 2 -> 5 -> 2

</pre>
<pre>
4 >= 3
rightPtr.next = head 
					rightHead = dummyNode -> 4 -> 3 -> 2 -> 5 -> 2
rightPtr = rightPtr.next
					rightPtr = 4 -> 3 -> 2 -> 5 -> 2
					
head = head.next 
					head = 3 -> 2 -> 5 -> 2
</pre>

<pre>
3 >= 3
rightPtr.next = head 
					rightHead = dummyNode -> 4 -> 3 -> 2 -> 5 -> 2
rightPtr = rightPtr.next
					rightPtr = 3 -> 2 -> 5 -> 2
					
head = head.next 
					head = 2 -> 5 -> 2
</pre>
<pre>
2 < 3
leftPtr.next = head 
					leftHead = dummyNode -> 1 -> 2 -> 5 -> 2
leftPtr = leftPtr.next 
					leftPtr = 2 -> 5 -> 2
					
head = head.next 
					head = 5 -> 2
</pre>
<pre>
5 >= 3
rightPtr.next = head 
					rightHead = dummyNode -> 4 -> 3 -> 5 -> 2
rightPtr = rightPtr.next
					rightPtr = 5 -> 2

head = head.next 
					head = 2
</pre>
<pre>
2 < 3
leftPtr.next = head 
					leftHead = dummyNode -> 1 -> 2 -> 2
leftPtr = leftPtr.next 
					leftPtr = 2

head = head.next 
					head = null					
</pre>

<br>At the end, rightPtr will be pointing to last element that should be in right half
<br>Any element attached to it are extra only, therefore, we can set rightPtr.next as null
<br>=> rightPtr.next = null
<br>
<br>And at the end, leftPtr will be pointing to left end, which needs to be attached to right half of linked list
<br>=> leftPtr.next = rightHead.next
<br>
<br>result = leftHead.next // because leftHead points to sentinal node
<br>rightPtr.next = head 
