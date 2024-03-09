# Leetcode 11. Container With Most Water

## Link to the questions

[Leetcode 11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

## Problem solving thought process

Using two pointers can be use to solve this problem.

Key points needs to be considered.

1. We use the min height
2. Area = min height \* width.

## Code and Explanation

```java
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i=0;
        int j=height.length-1;

        while(i<j){
            int width = j - i;
            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min*width);

            if(height[i] > height[j]){
                j--;
            } else {
                i++;
            }

        }

        return max;
    }
}
```

Complexity
Time - O(n)
Space - O(n)
