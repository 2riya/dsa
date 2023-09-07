Use a sentinel node for keeping track of head, useful for edge cases, when left == 1

Step 1: Move ptr to left
<br>
<br> Step 2: Reverse linked list from left to right
<br>
<br> Step 3: Adjust pointers adjacent to reversed portion, i.e.,
```plaintext
left <- node at left pos
right <- node at right pos

leftOfLeft <- node at left - 1
rightOfRight <- node at right + 1

leftOfLeft should point to right
left should point to rightOfRight
```
