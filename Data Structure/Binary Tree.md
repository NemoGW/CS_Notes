## Binary Tree

|                                               LeetCode                                               | Level | Solution |
| :--------------------------------------------------------------------------------------------------: | :---: | :------: |
|   [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)   |  🟢   |          |
| [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) |  🟢   |          |
|        [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)        |  🟢   |          |

### Binary Tree Sudo code

Let's start with the sudo code for binary tree

```java
void traverse(TreeNode root) {
    if (root == null) {
        return;
    }
    // pre-order traversal
    traverse(root.left);
    // in-order traversal
    traverse(root.right);
    // post order traversal
}
```

All questions of binary tree can be resolved by this sudo code. Taking closer look at it, what is the `traverse()` function doing?

- It is basically iterating through all nodes of tree. Which is same as the `array` or `linkedlist`

For example:

```java
/* Recursion iteration through array */
void traverse(int[] arr, int i) {
    if (i == arr.length) {
        return;
    }
    // pre-order
    traverse(arr, i + 1);
    // post-order
}

/* Recursion iteration through LinkedList */
void traverse(ListNode head) {
    if (head == null) {
        return;
    }
    // pre-order
    traverse(head.next);
    // post-order
}
```

So what exactly is pre-order / post-order?

- Pre-order is simply the time of action when entering a Node.
- Post-order is simply the time of actio when exiting a Node.

For example: How do you print out all element of the array?

- You will print the array element at post-order.

```java
/* Recursion iteration through array */
void traverse(int[] arr, int i) {
    if (i == arr.length) {
        return;
    }
    // pre-order
    traverse(arr, i + 1);
    System.out.print(arr[i]);
}
```

### Pre, In, Post-order

1. Inorder - left root right
2. Preorder - root left right
3. Postorder - left right root

Therefore, the Pre, In, and Post-order are simply just 3 different time frame. And in a binary tree, all `nodes` will be having its unique Pre, In and Post-orders.

**And solving a binary tree question is adding logic onto the 3 different time frame and apply with the sudo code**

### Binary Tree Solving Algo

Binary Tree usually have two solving algo

1. Recurrsion (Backtracking Algo)
2. Dynamic Programming (Separating trees into smaller nodes) Algo

For example: The Preorder Traversal

```java
List<Integer> res = new LinkedList<>();

//return the result
public List<Integer> preOrderTraverse(TreeNode root){
    traverse(root);
    return res;
}

//traverse through BT
public void traverse(TreeNode root){
    if(root == null) return;

    res.add(root.val);
    traverse(root.left);
    traverse(root.right);
}
```

Now using dynamic (breaking in to parts of trees.)
We know that, for preorder it is - root, left, right nodes.
Therefore, breaking down the problem, the preoder will be:
**preorder = root + preorder for left tree + preorder for right tree**

```java
List<Integer> preorderTraverse(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
        return res;
    }
    //preorder results, so adding at this position
    res.add(root.val);

    res.addAll(preorderTraverse(root.left));

    res.addAll(preorderTraverse(root.right));
    return res;
}
```

**One important thing about the preorder VS postorder**

1. Preorder can only obtain the data passed by the parent node from the parameters.
2. Postorder can not only obtain the data but also obtain the data passed back by the subtree through the function return value.

For example: Getting the longest diameter of a binary tree

Using preorder:

```java
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // calcuate max diameter for everynode
        traverse(root);
        return maxDiameter;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // calcuate diameter for everynode
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        // upodating
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    // max depth
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

The worst case will be O(N^2). Because we will need maxDept at every node to calculate the max depth.

But using postorder:

```java
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // postorder position
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        //postorder position
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

returns O(N) complexity.
