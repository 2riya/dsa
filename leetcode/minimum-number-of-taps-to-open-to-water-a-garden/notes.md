Given a tap i,
It can water in the range of [i - ranges[i], i + ranges[i]]
<br>

**Point to note:** Intervals should be continuous, i.e.,
<pre>
If range[0] = 0
and range[1] = 0

It means Tap0 can water only at 0th point
and Tap1 can water at only 1st point

And hence, 0 to 1 range will be left unwatered
Therefore, garden cannot be watered in this example
</pre>
<br>

**Intuition:**
<br>
Step 1: Given ranges of tap, create intervals

Step 2: Remove all covered intervals, i.e., those intervals that are a part of other intervals

Step 3: Check if all remaining intervals are continuous 
<br>If there's any gap, return -1 (i.e., answer doesn't exist)



