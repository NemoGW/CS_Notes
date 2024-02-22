# BFS Algorithm

|                                             LeetCode                                             | Level | Solution                                                                                                                                       |
| :----------------------------------------------------------------------------------------------: | :---: | ---------------------------------------------------------------------------------------------------------------------------------------------- |
| [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) |  🟢   | [Solution](https://github.com/NemoGW/CS_Notes/blob/main/Leetcode/DFS%20%26%20BFS/BFS-LeetCode111.md#leetcode-111-minimum-depth-of-binary-tree) |
|                [752. Open the Lock](https://leetcode.com/problems/open-the-lock/)                |  🟠   |

The core idea of BFS Algorithem is simply just imagine that there is a node, and every node has a linked to other nodes. Generally we will be using **LinkedList** data structures to perform BFS.

The main difference bettwen BFS and DFS is that **BFS will find the shortest path, but it will be having a bigger space complexity than DFS**

### Algorithm

Problems involving using BFS will be some type of the following. **Asking you from a "graph", find the **start** and the **target** distance**.

For instance:
Walking through a maze, find the shortest path?
Having two strings, only one character can be changed at a time. How many times of changes are needed to change from String 1 to String 2?

Sudo code for BFS

```java
int BFS(Node start, Node target){
    Queue<Node> q; //the queue needed for bfs
    Set<Node> visited; //aviod duplicated nodes

    q.offer(start); //adding start
    visited.add(start);

    while(q not empty){
        int size = q.size();
        /* going to the next node/spread out the nodes in queue */
        for(int i=0; i<size; i++){
            Node cur = q.poll();
            /* going to the next node/spread out the nodes in queue */
            if(cur is target){
                return step;
            }
            /* else add the current node into queue */
            for(Node x : cur.adj()){
                if(x not in visited){
                    q.offer(x);
                    visited.add(x);
                }
            }
        }
    }

    /* no target */
    return no target
}
```
