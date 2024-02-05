# Leetcode 977. Squares of a Sorted Array

## Link to the questions

[LeetCode 27. Remove Element](https://leetcode.com/problems/squares-of-a-sorted-array/description/)

## Question description

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

```
Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

```

And the constrains are:
 - 1 <= nums.length <= 104
 - -104 <= nums[i] <= 104
 - nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

## Problem solving thought process

The first approach would be just simply squaring the element and sorting them afterward.

The second approach - using two pointers
1. Left and right pointer.
2. Square the element.
3. Compare the value 
4. Traverse the pointers.


## Code and Explanation

Apporach 1:
```java
public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ans[i] = nums[i]*nums[i];
        }

        Arrays.sort(ans);

        return ans;
    }
```
Complexity:
Time - O(Nlog(N))
Space - O(N)

Approach 2:

We know that the largest value after squaring will always be on the end of the new array, and the element is present either by the very left pointer or the right pointer. So that we also need a "i" value representing the end of the new array.

```java
public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length-1;
        int i = nums.length-1;

        while(right>=left){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare < rightSquare){
                ans[i] = rightSquare;
                right--;
            } else {
                ans[i] = leftSquare;
                left++;
            }

            i--;
        }

        return ans;
    }
```

Complexity:
Time - O(N)
Space - O(N)