# Leetcode 19. Remove Nth Node From End of List

## Link to the questions

[Leetcode 19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

## Question description

Given the head of a linked list, remove the nth node from the end of the list and return its head.

```
Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

Example 2:
    Input: head = [1], n = 1
    Output: []

Example 3:
    Input: head = [1,2], n = 1
    Output: [1]
```

And the constrains are:
 - The number of nodes in the list is sz.
 - 1 <= sz <= 30
 - 0 <= Node.val <= 100
 - 1 <= n <= sz

## Problem solving thought process

Keep in mind that this question is singly Linked Listed. Therefore, there are no way to backtrack. Thus, we will be needing two pointers (first and second) to keep track of the position of the nodes.

Since we know that the list is "symmitrical". For example
```
1 -> 2 -> 3 -> 4 -> 5
```
Removing the 2nd element from the end (node 4). We will need to point 3 -> 5, which is the same as pointing from 1 -> 2.

Thus, we can have a pointer pointing at the beginning of the list, and the other pointer point at the nth position/nth node ahead.

1. Create 2 pointers pointing at the beginning (dummy node)
2. Move second pointer nth node ahead
3. Move both first and second pointers simultaneously until second reaches the end of the list.
4. Remove the element by first.next = first.next.next

## Code and Explanation

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy, second = dummy;

        for(int i=0; i<n; i++){
            second = second.next;
        }

        while(second.next!=null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return dummy.next;

    }
```

Complexity:
Time - O(N)
Space - O(1)