# Leetcode 701. Insert into a Binary Search Tree

## Link to the questions

[LeetCode 701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/description/)

## Question description

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

```
Example 1:
    Input: root = [4,2,7,1,3], val = 5
    Output: [4,2,7,1,3,5]

Example 2:
    Input: root = [40,20,60,10,30,50,70], val = 25
    Output: [40,20,60,10,30,50,70,null,null,25]

Example 3:
    Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
    Output: [4,2,7,1,3,5]
```

And the constrains are:
 - The number of nodes in the tree will be in the range [0, 104].
 - -108 <= Node.val <= 108
 - All the values Node.val are unique.
 - -108 <= val <= 108
 - It's guaranteed that val does not exist in the original BST.

## Problem solving thought process

We know that a binary tree is sorted, where left subtrees are smaller, and right subtrees are larger.

1. If root is null we return a new node(val).
2. If value < root.val we traverse left subtree.
3. If value > root.val we traverse right subtree.

## Code and Explanation

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
```

Complexity:
Time - O(N)
Space - O(N)