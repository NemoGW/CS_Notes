# Leetcode 141. Linked List Cycle

## Link to the questions

[Leetcode 141. Linked List Cycle]([https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/](https://leetcode.com/problems/linked-list-cycle/description/))

## Question description

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

```
Example 1:
  Input: head = [3,2,0,-4], pos = 1
  Output: true
  Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
  Input: head = [1,2], pos = 0
  Output: true
  Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
  Input: head = [1], pos = -1
  Output: false
  Explanation: There is no cycle in the linked list.

```

And the constrains are:
 - The number of the nodes in the list is in the range [0, 104].
 - 105 <= Node.val <= 105
 - pos is -1 or a valid index in the linked-list.

## Problem solving thought process

The idea of this problem is to see that if the linkedlist makes any loop after the tail. Therefore, we can use two pointers to keep in track of the position of the nodes and see if they make a loop or not.

If the linkedlist does not make a loop, when we traverse through the list, it will eventually reach ***null***.

Here we can introduce two pointers ***fast*** and ***slow***.
The fast pointer will move two position at once, while the slow pointer only move one position at once. If the pointer ***never*** interact, it means that there are no loop in the list.

## Code and Explanation

```java
public boolean hasCycle(ListNode head) {
        ListNode node = new ListNode();

        if(head == null){
            return false;
        }

        node.next = head;

        ListNode slow = node;
        ListNode fast = node.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
```

Complexity:
Time - O(N)
Space - O(1)
