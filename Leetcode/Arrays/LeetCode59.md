# Leetcode 59. Spiral Matrix II

## Link to the questions

[LeetCode 59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/description/)

## Question description

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

And the constrains are:
 - 1 <= n <= 20

```
For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

## Problem solving thought process

This question is similar to question 54. Simply this question wants us to generate a square matrics.

### Maintaining four boundaries

Maintaining four boundaries and the direction of movement is crucial. The spiral filling process invariably involves changing directions during traversal. We will need to change the boundaries when we reach the boundaries while moving along the outermost layer.

However, looking at the example above, when we reach 8, we will need to go right instead of upward. Based on this we can conclude that the outer boundary is shrinked by the places that we have visited already.

## Code and Explanation

The idea is going from building the matrix from
1. (very top) left to right
2. (very right) up to bottom
3. (very bottom) right to left
4. (very left) bottom to up

and then the size shrinks.

```java
public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0, up = 0;
        int down = n-1, right = n-1;

        int count=1; 
        while(count<=n*n){

            //left going right
            for(int i=left; i<=right; i++){
                matrix[up][i] = count;
                count++;
            }

            //shrinking the top boundary
            up++;

            //up to down
            for(int i=up; i<=down; i++){
                matrix[i][right] = count;
                count++;
            }

            //shrinking the right boundary
            right--;

            //right to left
            for(int i=right; i>=left; i--){
                matrix[down][i] = count;
                count++;
            }

            //shrinking the bottom boundary
            down--;

            //bottom to up
            for(int i=down; i>=up; i--){
                matrix[i][left] = count;
                count++;
            }

            //shrinking the left boundary
            left++;
        }

        return matrix;
    }
```