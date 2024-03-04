# Leetcode 1071. Greatest Common Divisor of Strings

## Link to the questions

[Leetcode 1071. Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

```
Example 1:
    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"

Example 2:
    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"

Example 3:
    Input: str1 = "LEET", str2 = "CODE"
    Output: ""
```

And the constrains are:

- 1 <= str1.length, str2.length <= 1000
- str1 and str2 consist of English uppercase letters.

## Problem solving thought process

formula for gcd is gcd(b, a % b);
We have to check if str2 is part of str1 or vis-versa. - we can concat the string to see if they are equal.

## Code and Explanation

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals((str2+str1))){
            return "";
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int md = gcd(len1, len2);

        return str1.substring(0,md);

    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}
```

Complexity:
Time - O(n)
Space - O(n)
