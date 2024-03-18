# Leetcode 1004. Max Consecutive Ones III

## Link to the questions

[Leetcode 1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75)

## Question description

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

```
Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

```

And the constrains are:
- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.
- 0 <= k <= nums.length

## Problem solving thought process

Using sliding window should be able to solve this problem:
counter of 0 increases by 1 when pointers found 0

The window shrinks when:
- counter of 0 is greater than k

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
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;
        int ans=0;
        
        while(right<nums.length){
            if(nums[right] == 0){
                count++;
            }

            right++;

            while(left < right && count > k){
                if(nums[left] == 0){
                    count--;
                } 
                left++;
            }

            ans = Math.max(ans, right-left);
        }

        return ans;
    }
```

Complexity:
Time - O(N)
Space - O(1)