get all rotten oranges

at each min, all oranges adjacent to them will rot

therefore, if initially, bfs[o1, o2, o3]

then at first min, neighbors of o1, o2 and o3 will rot and neighbors will be added to bfs queue

visited need not be maintained,
<br>as we are only visited cells with fresh orange (condition grid[cr][cc] == 1)
<br>and marking those as rotten (grid[cr][cc] = 2) once considered


**Time Complexity:**
<br>m * n <- for no. of cells
<br>4 <- for 4 directions

=> 4 * m * n
<br>=> O(m * n)



