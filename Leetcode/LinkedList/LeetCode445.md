# Leetcode 445. Add Two Numbers II

## Link to the questions

[Leetcode 141. Linked List Cycle](https://leetcode.com/problems/add-two-numbers-ii/description/)

## Question description

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

```
Example 1:
    Input: l1 = [7,2,4,3], l2 = [5,6,4]
    Output: [7,8,0,7]

Example 2:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [8,0,7]

Example 3:
    Input: l1 = [0], l2 = [0]
    Output: [0]

```

And the constrains are:

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

Follow up: Could you solve it without reversing the input lists?

## Problem solving thought process

Begin the problem with two ideas:

1. Reverse the list -> add -> reverse back;
2. Using Stack.

The follow up wants to solve it without reversing the input lists. Therefore, the approach is to use **_Stack_**. Stack is first in last out, so it can be use to do the math manipuation.

Steps:

1. Push list1 and list2 into stack1 and stack2
2. while(!s1.isEmpty() || !s2.isEmpty() || carry > 0)
   - we will loop until all list are empty, and if there are carry ons we will added to the very beginning of the answer list.
3. sum = s1.pop + s2.pop + carry
4. if sum >= 10 then carry = 1, and sum = sum - 10

## Code and Explanation

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode();

        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0){
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;

            ListNode current = new ListNode(sum);
            current.next = dummy.next;
            dummy.next = current;
        }

        return dummy.next;
    }
```

Complexity:
Time - O(N)
Space - O(N)
