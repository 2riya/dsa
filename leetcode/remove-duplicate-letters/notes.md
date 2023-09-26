Given 2 constraints:
1. Resultant string should be a subsequence, i.e., relative ordering of characters should be maintained

2. In case of multiple possible subsequences with non-repeating characters, return the lexicographically smallest one


**Approach:**
<br>Maintain a monotonically increasing stack
<br>This will store characters as they appear in string
<br>Characters will be popped out if a new character is lesser than top and top has further occurrences in the input string

**Note:** Once a character is traversed from the input string, it means that particular occurrence won't be considered again and hence reduce its frequency irrespective of whether it was added to the result or not
