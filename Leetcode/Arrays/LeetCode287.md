# Leetcode 287. Find the Duplicate Number

## Link to the questions

[Leetcode 287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/)

## Question description

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

```
Example 1:
    Input: nums = [1,3,4,2,2]
    Output: 2

Example 2:
    Input: nums = [3,1,3,4,2]
    Output: 3

And the constrains are:
- 1 <= n <= 105
- nums.length == n + 1
1 <= nums[i] <= n
- All the integers in nums appear only once except for precisely one integer - which appears two or more times.
```

Follow up:

- How can we prove that at least one duplicate number must exist in nums?
- Can you solve the problem in linear runtime complexity?

## Problem solving thought process

There are many ways we can use to find a duplicate in an array. Or duplicate in any cases.

1. The brutal force / sorting

   - Using two for loops for brutal force; however, it is O(n^2) time complexity, and it will often exceed limited time if the array is big.
   - We can also use Arrays.sort() or any sorting algo to sort the array, then check if i = i+1;

2. HashSet

   - Store into hashset and check if set contains (same with hashmap).

3. Binary Search (we will focus on this)

## Code and Explanation

```java
public int findDuplicate(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len-1;

        while(low < high){
            int mid = low + (high-low) / 2;
            int count=0;
            for(int i=0; i<len; i++){
                if(nums[i]<=mid){
                    count++;
                }
            }

            if(count<=mid){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return low;
    }
```
