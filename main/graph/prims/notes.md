Prim's algorithm is a greedy algorithm, that works by picking any vertex at random (say, v1)
<br>Then from all the edges, starting from v1, it will pick the minimum weight edge

Say, v2 is the vertex that min weight edge from v1 connects to

Now, v1 and v2 are visited, and we can select the min weight and not already visited edge starting from either v1 or v2

This process will be repated until all vertices of graph are visited

<hr>

**Time Complexity:**
<br> 
Depending upon the approach used to find the minimum weight edge starting from vertex 'v'

Approach 1 : Using min heaps
<br> Time complexity will be O(ElogE)

Approach 2 : Using List 
<br> Time complecity will be O(E<sup>2</sup>)

<hr>

**Applications:**
1. Travelling salesman problem
2. Network of roads connecting all cities

<hr>

**Key Differences:**
1. It works better for Dense Trees than Kruskal Algorithm
2. Here, tree can start from any random vertex, whereas in Kruskal's algorithm, it starts from min weighted edge
