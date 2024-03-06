# Leetcode 334. Increasing Triplet Subsequence

## Link to the questions

[Leetcode 334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

```
Example 1:
    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.

Example 2:
    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.

Example 3:
    Input: nums = [2,1,5,0,4,6]
    Output: true
    Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
```

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?

## Problem solving thought process

We can solve this question by using brutal force, however using multiple for-loops will cause the time to be large.

In this case, we can keep track of the smallest number, and the second smallest, if we encounter any number which is greater than these two, then there is a triple.

## Code and Explanation

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }

            if(nums[i] < secMin && nums[i] > min){
                secMin = nums[i];
            }

            if(nums[i] > secMin){
                return true;
            }
        }

        return false;
    }
}
```

To modify this code,

```java
public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= min){
                min = nums[i];
            } else if(nums[i] <= secMin){
                secMin = nums[i];
            } else{
                return true;
            }
        }

        return false;
    }
```

Complexity:
Time - O(N)
Space - O(1)
