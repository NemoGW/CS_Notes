Dynamic program String

# Leetcode 22. Generate Parentheses

## Link to the questions

[Leetcode 22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/)

## Question description

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

```
Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
    Input: n = 1
    Output: ["()"]
```

And the constrains are:
 - 1 <= n <= 8

## Problem solving thought process

This problem looks like a problem where we had to find all the possible solutions. Frequently, these kind of problem we can approach with the ***[Backtracking]***(..Algorithms/backtracking.md) algorithm

Looking at the problem, we know that it will always start with '('.
We can introduce two variables ***Left*** and ***Right*** to represent the parenthesis.

1. If left parenthesis is < n, then we will have to add the '(', and increment the left value.
2. If right parenthesis is < left, then we will have to add the ')' and increment the right value.

## Code and Explanation

```java
public ListNode removeNthFromEnd(ListNode head, int n) {

    }
```

Complexity:
