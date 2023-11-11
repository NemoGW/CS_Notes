# Leetcode 530. Minimum Absolute Difference in BST

## Link to the questions

[Leetcode 530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

## Question description

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

```
Example 1:
    Input: root = [4,2,6,1,3]
    Output: 1

Example 2:
    Input: root = [1,0,48,null,null,12,49]
    Output: 1
```

And the constrains are:
- The number of nodes in the tree is in the range [2, 104].
- 0 <= Node.val <= 105

## Problem solving thought process

I did not have any thoughts at first glance. But if we look at the question, it wants us to keep track of the ***Minimum and Absolute*** so we know that we need a bigger number - smaller number to make the solution always positive.

Therefore, ***inorder trasversal*** is needed. With inorder the current node will always be bigger than the previous node.

## Code and Explanation

```java

    //need a node to keep track of the previous node
    int difference = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        diff(root);
        return difference;
    }

    public void diff(TreeNode root){
        if(root == null){
            return;
        }

        //inorder
        diff(root.left);
        if(prev != null){
            difference = Math.min(difference, root.val - prev.val);
        }
        prev = root;
        diff(root.right);
    }
```

Complexity:
Time - O(N)
Space - O(N), bestcase O(log N)