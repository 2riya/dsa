### Approach
linked list should be split into 'k' partitions
<br>therefore, each partition will contain `k/len` nodes

but if len is not fully divisible by k, then 1 extra node will be added to partitions from left

k is no. of partitions to be made
<br>after each partition is done
<br>remaining partitions to be made gets decremented by 1, and len gets updated to remaining no. of nodes
<br> Note: No. of partitions with extra node = len % k (Not implemented)

### Time Complexity
n <- to compute length of list

k <- while loop time complexity
<br>while loop will run k times, to fill result array
<br>inside while loop, the method will run at max 'n' times, which will be when k == 1
<br>therefore, while loop complexity = max(n, k)

Hence, Time Complexity = O(n + k)

### Space Complexity
Only extra space used is for result array, i.e., O(k)
