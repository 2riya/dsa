Matrix can be traversed twice, once to store what all rows and cols are zero and then to update those rows and cols to 0.
<br>
This cannot be done simultaneously as matrix needs to be updated in-place and it couldn't be tracked in a single traversal what rows and cols were initially zero.
<br><br>
To implement this, let's maintain one array rows of length equals to matrix.length and another array cols of length = matrix[0].length
<br> For each element, m[i][j] in matrix, if it's 0, set row[i] = -1 and col[j] = -1
<br> We are using -1 to indicate that that particular row or col is 0
<br> Now, we'll traverse the matrix again and for each m[i][j], if row[i] == -1 or col[j] == -1, set m[i][j] = 0

Pseudocode:
<pre>
for (i = 0 to m.length - 1) 
    for (j = 0 to m[0].length - 1) 
        if (m[i][j] == 0) 
            rows[i] = -1;
            cols[j] = -1;

for (i = 0 to m.length - 1) 
    for (j = 0 to m[0].length - 1) 
        if (rows[i] == -1 || cols[j] == -1)
            m[i][j] = 0;
</pre>
T.C. = O(n^2)
<br> S.C. = O(n + m)

<hr>
We can eliminate the extra space by making use of zeroth row and zeroth column of the matrix to store which row or col contains zero
<br> We'll need to separately store whether zeroth row or zeroth col itself needs to be set to zero, this we will do by maintaining two booleans
<br> We'll need to implement it this way because if we make zeroth row/col zero initially, then the data related to other rows/cols it stores will also be gone
<br> 
<pre>
boolean row = false;
boolean col = false;

for (int i = 0; i < m[0].length; i++)
    if (m[0][i] == 0)
        row = true;

for (int j = 0; j < m.length; j++)
    if (m[j][0] == 0)
        col = true;

for (int i = 1; i < m.length; i++)
    for (int j = 1; j < m[0].length; j++)
        if (m[i][j] == 0)
            m[i][0] = m[0][j] = 0;

for (int i = 1; i < m.length; i++)
    for (int j = 1; j < m[0].length; j++)
        if (m[i][0] == 0 || m[0][j] == 0)
            m[i][j] = 0;

if (row)
    for (int i = 0; i < m[0].length; i++)
        m[0][i] = 0;

if (col)
    for (int j = 0; j < m.length; j++)
        m[j][0] = 0;
</pre>
T.C. = O(n^2)
<br> S.C. = O(1)
