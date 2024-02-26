# Leetcode 543. Diameter of Binary Tree

## Link to the questions

[LeetCode 543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)

## Question description

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

```
Example 1:
    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
    Input: root = [1,2]
    Output: 1
```

And the constrains are:

- The number of nodes in the tree is in the range [1, 104].
- -100 <= Node.val <= 100

## Problem solving thought process

The diameter of the binary tree is the longest path between any two nodes. Looking at the tree we know that the sum of max depth of the two child is the max diameter.

## Code and Explanation

```java
class Solution {
    int maxDia = 0;

    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int dia = left+right;
        maxDia = Math.max(dia, maxDia);

        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDia;
    }
}
```

Complexity:
Time - O(N)
Space - O(N)
