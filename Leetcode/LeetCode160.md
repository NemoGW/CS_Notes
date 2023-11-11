# 160. Intersection of Two Linked Lists

## Link to the questions

[Leetcode 142. Linked List Cycle II](https://leetcode.com/problems/intersection-of-two-linked-lists/description/)

## Question description

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.
Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

```
Example 1:
  Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
  Output: Intersected at '8'

Example 2:
  Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
  Output: Intersected at '2'

Example 3:
  Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
  Output: No intersection

```

And the constrains are:
 - The number of nodes of listA is in the m.
 - The number of nodes of listB is in the n.
 - 1 <= m, n <= 3 * 104
 - 1 <= Node.val <= 105
 - 0 <= skipA < m
 - 0 <= skipB < n
 - intersectVal is 0 if listA and listB do not intersect.
 - intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.


## Problem solving thought process

The idea of this problem is to make two linkedlist to start at the same "index position"
1. Get the difference of "skipA and skipB"
2. Make linkedList A or B traves first with the difference so they both at the same position.
3. Traverse the two list reaches the "meet" node.

## Code and Explanation

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        int lenA = 0, lenB = 0;

        while(nodeA!=null){
            lenA++;
            nodeA = nodeA.next;
        }

        while(nodeB!=null){
            lenB++;
            nodeB = nodeB.next;
        }

        nodeA = headA;
        nodeB = headB;

        if(lenA>lenB){
            int dif = lenA-lenB;
            while(dif!=0){
                nodeA = nodeA.next;
                dif--;
            }
        } else {
            int dif = lenB-lenA;
            while(dif!=0){
                nodeB = nodeB.next;
                dif--;
            }
        }

        while(nodeA!=nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        if(nodeA == nodeB){
            return nodeA;
        } else {
            return null;
        }
    }
```

Complexity:
Time - O(N)
Space - O(1)
