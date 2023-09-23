Kruskal's works by picking minimum weight edges one by one
<br> And skipping those edges, that leads to cycle formation

Note: An edge whose both vertices are already visited can still be considered in MST as the MST might still be disconnected. 
<br>Therefore, only visited shouldn't be the criteria
<br>Rather, it should be ensured that the two vertices aren't a part of same subset (or same connected componenet)

<hr>

**Time Complexity:**
<br>
TC: O(ElogV)
<br>E -> No. of edges, 
<br>V -> No. of vertices 

**Expln:** It is actually ElogE, because of sorting
<br>But no. of edges in a graph cannot exceed `V * V`
<br> => `E <= V * V`
<br> => `logE <= 2logV`

Therefore, to put tight upper bound, O(ElogV) is considered

See Also: <a href="https://stackoverflow.com/questions/20432801/time-complexity-of-the-kruskal-algorithm">Stack Overflow Reference</a>

<hr>

**Applications:**
1. LAN
2. TV Network

<hr>

**Key Differences:**
1. It works better for Sparse Trees than Prim's Algorithm
2. Here, MST starts from min weighted edge, whereas in Prim's algorithm, tree can start from any random vertex
