# Quick Sort
Quick Sort is a popular and efficient sorting algorithm that follows the divide and conquer approach. 
It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. 
The sub-arrays are then sorted recursively. This process is repeated until the whole list is sorted.

## Steps
1. Choose a Pivot: This can be any element from the array; common choices are the first, last, or middle element.
2. Partitioning: Rearrange the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it. After this partitioning, the pivot is in its final position.
3. Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
