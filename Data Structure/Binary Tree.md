## Binary Tree

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
