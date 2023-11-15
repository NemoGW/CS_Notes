# Leetcode 538. Convert BST to Greater Tree

## Link to the questions

[Leetcode 538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)

## Question description

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

 - The left subtree of a node contains only nodes with keys less than the node's key.
 - The right subtree of a node contains only nodes with keys greater than the node's key.
 - Both the left and right subtrees must also be binary search trees.

```
Example 1:
    Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Example 2:
    Input: root = [0,null,1]
    Output: [1,null,1]
```

And the constrains are:
 - The number of nodes in the tree is in the range [0, 104].
 - -104 <= Node.val <= 104
 - All the values in the tree are unique.
 - root is guaranteed to be a valid binary search tree.

## Problem solving thought process

We know that the value of a binary search tree is that on the right subtrees are always greater than it's roots.

We also want to add all the values of the nodes in sequence. And one way to traverse through the tree inorder is ***Inorder*** traversal.

But we want the values from high to low, so it will be reveersed inorder.

## Code and Explanation

```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        reInorder(root);
        return root;
    }

    int sum;

    public TreeNode reInorder(TreeNode root){
        if(root == null) return root;

        reInorder(root.right);
        sum += root.val;
        root.val = sum;
        reInorder(root.left);
        return root;
    }
}
```

Complexity:
Time - O(N)
Space - O(n) or O(log n) in balanced BST