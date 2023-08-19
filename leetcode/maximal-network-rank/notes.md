Description in simple terms -
1. Given a pair (a, b) in input, it indicates that city 'a' and city 'b' has a bidirectional road connecting them
2. Rank of network = For any pair (u, v), no. of roads directly connecting either u or v (or both, in which case it'll be counted only once)
<br>Note: For calculating rank, 'u' and 'v' need not necessarily be connected
3. Find max rank of network

<hr>
<b>Brute Force</b>
<br>T.C. = O(m * n^2)
<br> n -> no. of cities
<br> m -> no. of roads
<br>
<br> Space Complexity = O(1) // No extra space used
<br>
<br>1. Run 2 nested loops to find all pairs
<br>2. For each pair, traverse roads array to check road count of either cities of the pair
<br>3. Calculate rank for each pair and maximize it
<hr>
<b>Using Graph</b>
<br>1. Create an array that stores indegree of each vertex, i.e., no. of roads directly connecting that city
<br>2. Create a graph, either in matrix form or adjacency list, from roads array, where (a, b) indicates an edge a -> b and b -> a
<br>3. For each possible pair of road, find rank will be sum of their indegrees, and decrement by 1 if there's a road directly connecting them both (can be checked using graph created above in constant time)
<br>
<br> T.C.:
<br> n -> To create indegree array
<br> m -> To create graph out of roads array
<br> n<sup>2</sup> -> To compute pairs and caclulate rank
<br> => O(m + n<sup>2</sup>)
<br>
<br> Space Complexity:
<br> n -> For indegree array
<br> n<sup>2</sup> -> For graph
<br> => O(n<sup>2</sup>)
