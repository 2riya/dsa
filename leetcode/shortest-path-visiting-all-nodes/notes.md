This problem is similar to `Shortest Path to Get All Keys`, wherein nodes can be re-visited if key state isn't same

Here, nodes can be visted if path state changes, i.e.,
<br>A node `x` can be re-visited, if from the last time since it was visited, there has been a change in the path traversed so far

Visited will contain 2 params -> node, path_mask
<br>This is to ensure that same node (say `x`) shouldn't be visited again if no new node has been traversed since `x` was last visited
<br>This will ensure that code is not stuck in an infinite cycle

Since, there is no fixed source and starting from different nodes can result in different answers,
<br>Do BFS for each node considering it as source node and find minimum of all the paths starting from each of them
