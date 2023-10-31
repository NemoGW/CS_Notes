# Leetcode 27. Remove Element

## Link to the questions

[LeetCode 27. Remove Element](https://leetcode.com/problems/remove-element/description/)

## Question description

This question is relatively simple, it involves removing a given element from a list and returning the count of the remaining elements. 

And the constrains are:
 - 0 <= nums.length <= 100
 - 0 <= nums[i] <= 50
 - 0 <= val <= 100

## Problem solving thought process

1. We can set a pointer specifically to elements that are not the same as the given value.
2. If they are not the same, we increment the pointer.
3. Finally, return its value.

## Code and Explanation

```java
if(nums[i]!=val)
{
    int temp = nums[count];
    nums[count] = nums[i];
    nums[i] = temp;
    count++;
}
```

```java
public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        return count;
    }
```