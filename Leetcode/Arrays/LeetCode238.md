# Leetcode 238. Product of Array Except Self

## Link to the questions

[Leetcode 238. Product of Array Except Self](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

## Question description

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

```
Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
```

- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a - - 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

## Problem solving thought process

My initial approach was for every index, calculate the left product and the right product. Then replace the index with left \* right.

For example:

```java
for(int i=0; i<nums.length; i++){
    int left = 1;
    int right = 1;
    for(int j=0; j<i; j++){
        left = nums[j] * left;
    }

    for(int k=nums.length-1; k>i; k--){
        right = nums[k] * right;
    }

    ans[i] = left*right;
}
```

However this is very infficient due to O(n^2). So this won't work for a large array.

To modify we can introduce soemthing called prefix and suffix product. What happens here is, we get the product of the prefix and then multiply by the product from the suffix.

- First Pass (Left Products): Iterate through the array from left to right, calculating the running product of all elements to the left of each element.
- Second Pass (Right Products): Iterate through the array from right to left, calculating the running product of all elements to the right of each element, and multiply it with the left product stored from the first pass.

## Code and Explanation

```java
public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] ans = new int[length];

    // Left products
    int leftProduct = 1;
    for (int i = 0; i < length; i++) {
        ans[i] = leftProduct;
        leftProduct *= nums[i];
    }

    // Right products
    int rightProduct = 1;
    for (int i = length - 1; i >= 0; i--) {
        ans[i] *= rightProduct;
        rightProduct *= nums[i];
    }

    return ans;
}

```
