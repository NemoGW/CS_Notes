# LeetCode 328. Odd Even Linked List

## Link to the questions

[LeetCode 328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/)

## Question description

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.


```
Example 1:
    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]

Example 2:
    Input: head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]

```

And the constrains are:
 - The number of nodes in the linked list is in the range [0, 104].
 - -106 <= Node.val <= 106

## Problem solving thought process

Notice that we have to solve the problem in O(1) extra space, therefore using recursion is not the correct approach.
Which lead us to re-arrange the list in-place.

Looking at the problem we need to keep track of the Odd and Even nodes. Therefore we will need 2 references and 2 pointers.

1. The odd reference is the input head.
2. We need to create a pointer for traverse the list. -> oddPtr = head
3. WE need to create a even reference, referencing the head of the even nodes. -> evenHead = head.next;
4. Finally, we need a event pointer for traverse the list. -> evenPtr = evenHead.

## Code and Explanation

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        //odd pointer
        ListNode oddPtr = head;

        //even Node reference
        ListNode evenHead = head.next;

        //even pointer
        ListNode evenPtr = evenHead;

        //check for nullpointer conditions
        while(evenPtr!=null && evenPtr.next != null ){

            //connects the odd nodes & connect the even nodes
            oddPtr.next = oddPtr.next.next;
            evenPtr.next = evenPtr.next.next;

            //advance the pointer
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;
        }

        //point the end of odd list to even list
        oddPtr.next = evenHead;

        return head;
    }
}
```

Complexity:
Time - O(N)
Space - O(1)
