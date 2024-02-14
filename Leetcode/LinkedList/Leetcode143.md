# Leetcode 143. Reorder List

## Link to the questions

[Leetcode 143. Reorder List](https://leetcode.com/problems/reorder-list/description/)

## Question description

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

```
Example 1:
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

Example 2:
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]

```

And the constrains are:

- The number of nodes in the list is in the range [1, 5 * 104].
- 1 <= Node.val <= 1000

## Problem solving thought process

Solution 1: Storing
To solve this problem we can store each node into an arraylist and then arrange them as we are adding to the arraylist.

Solution 2: Reversing
Another way to solve this question is

1. find the mid-point node
2. reverse the other half
3. connect the nodes

e.g.
Suppose we have : 1 -> 2 -> 3 -> 4 -> 5 -> 6
We find the mid node and separate them to : 1 -> 2 -> 3 and 4 -> 5 -> 6
Reverse the half : 6 -> 5 -> 4
Connect two list : 1 -> 6 -> 2 -> 5 -> 3 -> 4

Solution 3: Recurrsive
This is a very smart approach which I saw in solutions. Basically if we can find a way to loop the pointer back to the corresponding head-tail pairs, we can connect the head to the "re-arranged list" then to the tails.

## Code and Explanation

Solution 1: Storing

```java
public void reorderList(ListNode head) {

        if(head == null) return;

        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }

        //initialize two pointers
        int i=0;
        int j=list.size()-1;

        while(i < j){
            list.get(i).next = list.get(j);
            i++;

            //for even number of nodes.
            if(i==j) break;

            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }
```

Solution 2: Reverse

```java
public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reverseList(newHead);

        while(newHead!=null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while(head!=null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }
```

Solution 3: Recursive

```java
public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        int len = 0;
        ListNode ptr = head;

        while(ptr!=null){
            len++;
            ptr = ptr.next;
        }

        reorderList(head, len);
    }

    public ListNode reorderList(ListNode head, int len){
        if(len == 1){
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }

        if(len == 2){
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = reorderList(head.next, len-2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;

        return outTail;
    }

```
