## Intuitively

- Since nearest 0 needs to be found, BFS should be used.
- Also, given the constraints of 10^4, DP can be used.

## DP

For DP, it can be thought of as,

- Distance of current 1 will be min of distance of its adjacent cells plus 1.
- But we cannot simultaneously compute in all 4 directions.
- Therefore, we'll first move in forward direction (i.e., right and bottom) and compute distance.
- Then we can go in backward directions, (i.e., top and left) to minimize the distance.

**Time Complexity:**

- 2 loops will run for matrix traversal, i.e., 2 * m * n, i.e., `O(m * n)`.

## BFS


