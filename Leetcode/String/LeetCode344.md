# Leetcode 344. Reverse String

## Link to the questions

[Leetcode 344. Reverse String](https://leetcode.com/problems/reverse-string/description/)

## Question description

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

```
Example 1: 
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]
```

And the constrains are:
- 1 <= s.length <= 105
- s[i] is a printable ascii character.

## Problem solving thought process

Since we want the solution to be in-place, this means that we cannot introduce extra memory to it.

Simply to reverse the string, we can just swap the beginning and end charater.

Introducing two pointers, left and right.
left = 0;
right = length - 1;

## Code and Explanation

```java
class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}
```

Complexity:
Time - O(N)
Space - O(1)