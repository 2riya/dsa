**Approach**

Starting from first node, keep making each node point to the node left of it

**Pseudocode:**

```plaintext
p = null
q = 1
r = null

r = q.next
q.next = p
p = q
q = r
```

**Dry Run:**

```plaintext
for q = 1
r = 2
1.next = p = null
p = 1
q = 2

for q = 2
r = 2.next = 3
2.next = p = 1
p = 2
q = 3

....so on
```
p will eventually point to new head of linked list
