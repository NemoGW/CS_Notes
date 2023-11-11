# Leetcode 142. Linked List Cycle II

## Link to the questions

[Leetcode 142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/description/)

## Question description

GGiven the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

```
Example 1:
  Input: head = [3,2,0,-4], pos = 1
  Output: tail connects to node index 1
  Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
  Input: head = [1,2], pos = 0
  Output: tail connects to node index 0
  Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
  Input: head = [1], pos = -1
  Output: no cycle
  Explanation: There is no cycle in the linked list.

```

And the constrains are:
 - The number of the nodes in the list is in the range [0, 104].
 - 105 <= Node.val <= 105
 - pos is -1 or a valid index in the linked-list.

## Problem solving thought process

This problem is very similar to [Leetcode 141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/). The only difference is that, after we findout there is a loop, we need two more pointers.
1. One pointer points at the position of where the loops begins.
2. The second pointer starts from the beginning, and goes to the node of the first pointer.

## Code and Explanation

```java
public ListNode detectCycle(ListNode head) {
        ListNode node = new ListNode();
        if(head == null){
            return null;
        }

        node.next = head;

        ListNode slow = node;
        ListNode fast = node.next;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode start = node.next;
                ListNode meet = fast;
                while(start!=meet){
                    start = start.next;
                }

                return start;
            }
        }

        return null;
    }
```

Complexity:
Time - O(N)
Space - O(1)
