# Leetcode 209. Minimum Size Subarray Sum

## Link to the questions

[Leetcode 209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

## Question description

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

And the constrains are:
 - 1 <= target <= 109
 - 1 <= nums.length <= 105
 - 1 <= nums[i] <= 104

```
For example,

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

## Problem solving thought process
Here we will be having two pointers - start & end
1. One pointer (end) iterate through the nums array list.
2. While the end pointer iterates add values together until it statisify the condition of sum >= target.
3. Other pointer (start) iterate through the nums array list.
4. Sum - the start pointer value until sum < target.
5. Check for the minimum length.

## Code and Explanation
```java
public int minSubArrayLen(int target, int[] nums) {
        int start=0, sum=0;
        int minLen = Integer.MAX_VALUE;

        for(int end=0; end<nums.length; end++){
            sum+=nums[end];
            while(sum>=target){
                minLen = Math.min(minLen,end-start+1);
                sum-=nums[start];
                start++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return 0;

        return minLen;
    }
```