**Without Sorting**

Need to make frequency of each character unique
<br>First, compute frequency of each character

Now since only operation allowed is to delete a character, frequencies can be decremented until they become unique or 0

With each decrement in frequency, no. of delete operation is incremented by 1

----

**Priority Queue/Sorting Logic**

In descending order of frequencies, if any frequency is equal to prev frequency, then decrement the current frequency by 1 and move forward
<br>Also, handle cases with 0 frequency
