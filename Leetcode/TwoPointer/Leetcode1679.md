# Leetcode 1679. Max Number of K-Sum Pairs

## Link to the questions

[Leetcode 1679. Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

## Problem solving thought process

Using 2 pointers.

1. Sort the array from lowest to greatest.
2. Increment and decrement pointers when i + j = k;

## Code and Explanation

```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;

        int count=0;

        while(i < j){
            if(k-nums[i] == nums[j]){
                count++;
                i++;
                j--;
            } else if(nums[i] + nums[j] < k){
                i++;
            } else if(nums[i] + nums[j] > k){
                j--;
            }
        }


        return count;
    }
}
```

Complexity
Time - O(n)
Space - O(1)
