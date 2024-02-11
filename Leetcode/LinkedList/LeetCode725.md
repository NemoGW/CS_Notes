# LeetCode 725. Split Linked List in Parts

## Link to the questions

[LeetCode 725. Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts/description/)

## Question description

Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

```
Example 1:
    Input: head = [1,2,3], k = 5
    Output: [[1],[2],[3],[],[]]

    Explanation:
    The first element output[0] has output[0].val = 1, output[0].next = null.
    The last element output[4] is null, but its string representation as a ListNode is [].

Example 2:
    Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
    Output: [[1,2,3,4],[5,6,7],[8,9,10]]

    Explanation:
    The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.


```

And the constrains are:
 - The number of nodes in the list is in the range [0, 1000].
 - 0 <= Node.val <= 1000
 - 1 <= k <= 50

## Problem solving thought process

The most confusing part of this question is in-case if the number of nodes cannot equally separate by k. Then the earlier array will have be bigger than or equal to the ones behind it (with a maximum of difference of 1).

Therefore, in this case, we can have to varaiables. 
***nPart*** - number of Node arrays that answer should return. eg. 10/3 = 3
***nExtra*** - number of extra node should be added to the earlier arrays. eg. 10/3 = 3 Remainder = 1

## Code and Explanation

```java
public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ptr = head; //initializing a pointer
        int count = 0;

        //counter the # of nodes
        while(ptr != null){
            count++;
            ptr = ptr.next;
        }

        //initalize ans Node array to the size of k
        ListNode[] ans = new ListNode[k];

        //reassign the pointer back to head;
        ptr = head;

        //calculate part and etra nodes
        int nPart = count / k;
        int nExtra = count % k;

        for(int i=0; i<k && ptr!=null; i++){

            //assign ans index to ptr nodes
            ans[i] = ptr;

            //if i < extra nodes 1 extra node should be added to the earlier arrays
            int size = nPart + (i < nExtra ? 1 : 0);

            for(int j=1; j<size; j++){
                ptr = ptr.next;
            }

            ListNode next = ptr.next;

            //set the current ptr.next = null to cut of the list. 
            ptr.next = null;
            ptr = next;
        }

        return ans;
    }
```

Complexity:
Time - O(N)
Space - O(1)
