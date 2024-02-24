# Leetcode 34. Find First and Last Position of Element in Sorted Array

## Link to the questions

[Leetcode 34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

## Question description

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

```
Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]

```

And the constrains are:
- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109
- nums is a non-decreasing array.
- -109 <= target <= 109

## Problem solving thought process

The array is sorted, and we need to find the target number with O(log n).
From the description we need to find the first and the last tagert number.

For example: [3, 3, 3] target = 3, then we should return [0, 3].

So we can implement the binarySearch for left boundary and right boundary.

## Code and Explanation

```java
class Solution {
    public int leftBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                right = mid;
            } else if (nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
    public int rightBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid;
            }
        }

        return left-1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target ){
            return new int[]{-1,-1};
        }
        
        int index1 = leftBinarySearch(nums, target);
        int index2 = rightBinarySearch(nums, target);

        if(nums[index1] != target && nums[index2] !=target){
            return new int[]{-1,-1};
        }
        return new int[]{index1,index2}; 
    }
}
```

Complexity:
Time - O(log N)
Space - O(1)