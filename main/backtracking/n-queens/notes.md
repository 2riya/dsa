Size of board = n*n
No. of queens = n

Queen can travel in 8 directions:
1. left
2. right
3. top
4. down
5. diagonally down
6. diagonally up
7. antidiagonally down
8. antidiagonally up

To avoid attacking, one thing for sure, no queen will be placed in same row

Therefore, place each queen in each row and check if no other queen is there in any of the 8 directions

Also, since queens are being placed row by row, no queen will be present in the forward direction, therefore, only four directions need to be checked - left, up, diagonally up, antidiagonally up

left -> same row, prev cols (this can also be skipped as no queen is there in same row)

Hence, 3 direction check only
1. up -> same col, prev rows (0 to i, j)
2. diagonally up -> i - 1, j - 1 (until i >= 0 && j >= 0)
3. antidiagonally up -> i - 1, j + 1 (until i >= 0 && j < n)
