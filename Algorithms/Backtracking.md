## Backtracking Algorithm

Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point of time (that is, backtracking and then trying again). This is often applied to constraint satisfaction problems, such as puzzles (like Sudoku), crosswords, and combinatorial optimization problems (like the Knapsack Problem).

Here's a broad view of how backtracking works:

1. **Choose**: Select a starting option from the possibilities available at the current step.
2. **Constrain**: Apply constraints to narrow down the options for the next step. If a constraint is violated, reject this option and backtrack.
3. **Goal Check**: Check if a complete solution has been reached. If so, return the solution.
4. **Backtrack**: If the current path does not lead to a solution, go back to the previous step and try another option.

Backtracking reduces the brute force search by eliminating the large number of paths that lead to dead ends, thereby solving the problem more efficiently than a naive approach that tries all possibilities.

![Backtracking IMG](assets/IMG_0006.png)

Listing out all the possibilities are one of the classic usage of ***Backtracking Algorithm***.

For example: ***Let N=3***
1. Starting with 1 and order them we will have: [1,2,3] , [1,3,2].
2. Starting with 2 and order them we will have: [2,1,3] , [2,3,1].
3. Starting with 3 and order them we will have: [3,1,2] , [3,2,1].
