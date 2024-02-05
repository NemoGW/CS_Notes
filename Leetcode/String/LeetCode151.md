# 151. Reverse Words in a String

## Link to the questions

[Leetcode 151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)

## Question description

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

```
Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

And the constrains are:
- 1 <= s.length <= 104
- s contains English letters (upper-case and lower-case), digits,  and spaces ' '.
- There is at least one word in s.

## Problem solving thought process
1. We know that we cannot have the leading and ending spaces, .trim() can be use for this.
2. We can have the index pointer starting from the end then go to the beginning so the string will be reversed.

## Code and Explanation

```java
class Solution {
    public String reverseWords(String s) {
        String[] newS = s.trim().split("\\s+");
        String ans = "";

        for(int i=newS.length - 1; i>0; i--){
            ans += newS[i] + " ";
        }

        return ans + newS[0];
    }
}
```

Complexity:
Time - O(N)
Space - O(N)