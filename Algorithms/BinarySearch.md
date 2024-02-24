## Binary Search

|                                                                       LeetCode                                                                        | Level | Solution
| :---------------------------------------------------------------------------------------------------------------------------------------------------: | :---: |
| [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) |  🟠   |
|                                          [704. Binary Search](https://leetcode.com/problems/binary-search/)                                           |  🟢   | https://github.com/NemoGW/CS_Notes/blob/main/Leetcode/BinarySearch/Leetcode704.md

Binary Search is searching algorithm where if you have n numbers. You do n/2 and /2 of each half until you find the number you are seaching for.
Time Complexity O(log n). **The list of n has to be sorted**

### Binary Search Sudo

```java
int binarySearch(int[] nums, int target){
    int left = 0, right = ...;

    while(...){
        int mid = left + (right - left) / 2;
        if(nums[mid] == target){
            ...
        } else if (nums[mid] < target){
            left = ...
        } else if (nums[mid] > target){
            right = ...
        }
    }

    return ...
}
```

**One technique to use in binary search is that, don't use an else statement. Use else if and specify all the conditions**

In the code reason to use `left + (right - left) / 2` and not just `(left + right) / 2` is because to avoid left and right to be a huge number.

### Binary Search usage.

**1. Finding a number**

Searching: [left, right]
Ending Condition: left = right+1;

```java
int binarySearch(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1; //**

    while(left <= right){
        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid; //**
        } else if (nums[mid]<target){
            left = mid + 1;
        } else if (nums[mid]>target){
            right = mid - 1;
        }
    }

    return -1;
}
```

Why in the while loop, <= not < ?

This is because we initialize `right` as `nums.legnth-1` not `nums.length`.

`nums.length-1` is like giving a close end -> `[left, right]`. Where as `nums.length` is giving a open end -> `[left, right)`.

When to use left = mid + 1, and when to use left = mid?

It depens on the situdation, in the code snip above, we have a condition of `if(nums[mid]==target)` this already look for the mid number, so we will further need to search for `[mid+1, right]` or `[left,right-1]`

**2. Searching for the leftmost bondary**
This is used when you want to find the **first** matching target from left to right.

Searching: `[left, right)`
Ending condition: `left = right`

```java
int left_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length; //**

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            right = mid; //**
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    if (left < 0 || left >= nums.length) {
    return -1;

    }
    return nums[left] == target ? left : -1;
    }
```

Why < not <= in the while loop?
Beacuase the `right` in this case is `nums.length`

**3. Searching in for the right boundary**

Searching: `[left,right)`
Ending Condition `left = right`

```java
int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length; //**

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            left = mid + 1; //**
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left - 1; //**
}
```
