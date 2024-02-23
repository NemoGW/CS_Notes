# Leetcode 46. Permutations

## Link to the questions

[Leetcode 46. Permutations](https://leetcode.com/problems/permutations/description/)

## Question description

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

```
Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

Example 3:
    Input: nums = [1]
    Output: [[1]]
```

## Problem solving thought process

We want to get all the combinations of the input, let say 1, 2, 3.
To do it by hand, we will first keep 1 as constant -> 1, 3, 2 and 1, 2, 3 and then 2 by constant yeilding 2, 1, 3 and 2, 3, 1.

If we would to draw this as a tree. It will be something like a decision tree. Where at every node, you are making a decision.

This way we can use the backtracking algo / dfs.

## Code and Explanation

Put in the frame for backtracking:

```java
void backtrack(Path track, Options){
    if(Ending Condition){
        result.add(Path track);
        return;
    }

    for(option : Options){
        option;
        backtrack(path, options);
        remove option;
    }
}
```

Here:

1. Path track = is stored in "track"
2. Options = the combos what are not presented in nums[]
3. Ending condition = all combos in nums are in track.

Full code:

```java
class Solution {

    //use to store ans
    List<List<Integer>> res = new LinkedList<>();

    //Path track - is stored in track
    //options - are the combinations which are not in the nums[];
    //ending condition - all combo in nums are presented in track;
    public void backtrack(int nums[], LinkedList<Integer> track){

        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            //make the decision
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();

        }
    }

    public List<List<Integer>> permute(int[] nums) {

        //use to track the path
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
}

```
