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

Two approaches

1. Reverse the string within the array
2. Using two pointers

## Code and Explanation

1. Within the array

```java
class Solution {
    public String reverseWords(String s) {
        String[] words=s.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1; i>0; i--){
            sb.append(words[i] + " ");
        }

        return sb.toString() + words[0];
    }
}
```

2. Using two pointers

```java
public String reverseWords(String s) {
        String[] words=s.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = words.length - 1;
        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        return String.join(" ", words);
    }
}
```

Complexity:
Time - O(N)
Space - O(1)
