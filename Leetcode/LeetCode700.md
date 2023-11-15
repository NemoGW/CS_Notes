# Leetcode 700. Search in a Binary Search Tree

## Link to the questions

[LeetCode 27. Remove Element](https://leetcode.com/problems/search-in-a-binary-search-tree/description/)

## Question description

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

```
Example 1:
    Input: root = [4,2,7,1,3], val = 2
    Output: [2,1,3]

Example 2:
    Input: root = [4,2,7,1,3], val = 5
    Output: []

```

And the constrains are:
 - The number of nodes in the tree is in the range [1, 5000].
 - 1 <= Node.val <= 107
 - root is a binary search tree.
 - 1 <= val <= 107

## Problem solving thought process

We know that a binary tree is sorted, where left subtrees are smaller, and right subtrees are larger.

1. If root is null we return null.
2. If value is found we return root.
3. If value < root.val we return left subtree.
4. If value > root.val we return right subtree.

## Code and Explanation

```java
public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        } else if(val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
```

Complexity:
Time - O(N)
Space - O(N)