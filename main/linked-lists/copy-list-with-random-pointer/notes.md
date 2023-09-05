### O(n) TC, O(n) SC
Use HashMap to store mapping of old node vs deep (or new) node
<br>Iterate over old nodes, for each old node, link the next and random pointers of deep node as per the hash value of the original node


<hr>

### O(n) TC, O(1) SC
HashMap is used to store the mapping of old vs new node
<br>Rather, insert the new node between old node and old node's next
<br>And similar to doing map.get(old), do old.next in order to access corresponding new nodes

Three traversals:
1. Merging new and old linked lists
2. Replicating random pointers of old linked list to new linked list
3. Detaching both the linked lists 
