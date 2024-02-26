# Leetcode 226. Invert Binary Tree

## Link to the questions

[LeetCode 226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)

## Question description

Given the root of a binary tree, invert the tree, and return its root.

## Problem solving thought process

2 ways to solve this question:

1. We can traverse through all the nodes of the tree. At every node, we can swap it's left and right child nodes.

```java
Node temp = root.left;
root.left = root.right;
root.right = temp;

traverse(root.left);
traverse(root.right);
```

2. Using the dp approach, we can revert the child trees and swap the left and right tree.

```java
TreeNode left = invertTree(root.left);
TreeNode right = invertTree(root.right);

root.left = right;
root.right = left;
```

## Code and Explanation

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
```

Complexity:
Time - O(N)
Space - O(N)
