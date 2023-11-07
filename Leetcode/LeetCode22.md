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

This problem looks like a problem where we had to find all the possible solutions. Frequently, these kind of problem we can approach with the [Backtracking](Algorithms/Backtracking.md) algorithm

Looking at the problem, we know that it will always start with '('.
We can introduce two variables ***Left*** and ***Right*** to represent the parenthesis.

1. If left parenthesis is < n, then we will have to add the '(', and increment the left value.
2. If right parenthesis is < left, then we will have to add the ')' and increment the right value.

## Code and Explanation

As what we disscused before we will be using backtracking algo to approach this problem.

```java
if(left < n) {
    backtrack(left+1, right, string + '(');
}

if(right < left){
    backtrack(left, right+1, string + ')');
}
```

Full code:

```java
public void helper(int n, int left, int right, List<String> list, String s){

        if(s.length() == n*2){
            list.add(s);
            return;
        }
        if(left < n){
            helper(n, left+1, right, list, s + "(");
        }

        if(right < left){
            helper(n, left, right+1, list, s+ ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, 0, 0, list, "");

        return list;
    }
```

Complexity:
Time - 
Space - O(n) for the best cause - considering only the recursive stack.
