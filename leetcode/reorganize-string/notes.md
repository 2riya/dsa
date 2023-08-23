<b> Counting and Priority Queue</b>
<br>Given that no two same characters are adjacent
<br>
<br>Intuitively, for a string to have such a representation, no character should appear more than half of string length
<br>
For any char ch, if freq(ch) > ceil(len/2), answer doesn't exist
<br>
<br>Now, to form the answer
<br>We'll start by taking 2 characters, with top most and second top most frequency
<br>Append them
<br>And decrement their frequency 
<br>And repeat this process until all characters are consumed
<br>
<br>Since, we are taking characters in pairs, we might end up with a character in the end
<br>We'll simply append it to the end of our result
<br>
<br>For storing, characters by frequency, max heap can be used
<br>And every time frequency is updated, we push char back to max heap if freq > 0
<br>
<br><b>Time Complexity:</b>
<br>Given n -> length of string
<br>k -> unique characters
<br>
<br>=> O(nlogk), where k <= 26
<br>
<br>For populating hash table and generating input and each poll and push operation taking logk time
<br>
<br> <b>Space Complexity:</b>
<br> 26 -> hash table
<br> k -> Priority Queue
<br> => O(k)
<hr>
<br><b> Counting & Even-Odd</b>
<br> This can be solved in O(n) time as follows:
<br> First, storing frequency of each char and validating for majority char will remain same as prev approach
<br> Once it is validated that ans exists, start with even indices and most frequent char
<br> For i = 0 and i+=2, fill in most frequent char at i 
<br> Once most frequent char is done, fill in other chars at i, and if i exceeds str.len, set i = 1, and continue with i += 2
<br>
<br> Note: After consuming the most frequent char, it's not necessary to pick second most freq char, as we are populating at alternate indices, so no same char will be adjacent
<br>
<br> <b>Time Complexity:</b> O(n)
<br> <b>Space Complexity:</b> O(k) // for hash table, where k <= 26
