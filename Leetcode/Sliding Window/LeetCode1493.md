# Leetcode 1493. Longest Subarray of 1's After Deleting One Element

## Link to the questions

[Leetcode 1493. Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

```
Example 1:
    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.

```

And the constrains are:
- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.

## Problem solving thought process

Another sliding window problem. Using sliding window should be able to solve this problem:
counter of 0 increases by 1 when pointers found 0

The window shrinks when:
- counter of 0 is greater than 1
- and if nums[left] is 0;

The sudo code for sliding window:
```java
while(left < right && right < s.size()){

    //make window bigger
    window.add(s[right]);
    right++;

    while(window needs shrink){
        window.remove(s[left]);
        left++;
    }
}
```

## Code and Explanation

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int count = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            right++;

            while(left < right && count > 1){
                if(nums[left] == 0){
                    count--;
                }

                left++;
            }

            ans = Math.max(ans, right-left-1);
        }

        return ans;
    }
}
```

Complexity:
Time - O(N)
Space - O(1)