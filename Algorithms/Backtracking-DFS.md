## Backtracking Algorithm

|                            LeetCode                             | Level |                                               Solutions                                                |
| :-------------------------------------------------------------: | :---: | :----------------------------------------------------------------------------------------------------: |
| [46. Permutations](https://leetcode.com/problems/permutations/) |  🟠   | [Solution](https://github.com/NemoGW/CS_Notes/blob/main/Leetcode/DFS%20%26%20BFS/BT-DFS-LeetCode46.md) |
|     [51. N-Queens](https://leetcode.com/problems/n-queens/)     |  🔴   |
|  [52. N-Queens II](https://leetcode.com/problems/n-queens-ii/)  |  🔴   |

Backtracking and DFS are the very similar algorithms. The minor difference is that Backtracking is traversing through treeNodes and DFS is traversing through Nodes.

**Simply BT and DFS are just that collection of the child of the treeNodes/Nodes**

For BT remeber the following problems needs to be addressed.

1. Visited nodes / Path
2. Options to proceed (childrens of the treeNode)
3. The ending conditions (Bottom level of the tree)

Sudo Code

```java
result = []
void backtrack(Path track, Options){
    if(Ending Condition){
        result.add(Path track);
        return;
    }

    for(option : Options){
        option;
        backtrack(path, options);
        remove option;
    }
}
```

**The main idea is to make a recurrsion in the for-loop. And before the recurrsion use the option that were chosen, then after the recurrsion remove the option**

Removing the option

- meaning backtracking, to backtrack a tree

```java
void traverse(TreeNode root){
    for(TreeNode child : root.children){
        traverse(child);
    }
}
```
