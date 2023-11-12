# Quick Sort
Quick Sort is a popular and efficient sorting algorithm that follows the divide and conquer approach. 
It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. 
The sub-arrays are then sorted recursively. This process is repeated until the whole list is sorted.

## Steps
1. Choose a Pivot: This can be any element from the array; common choices are the first, last, or middle element.
2. Partitioning: Rearrange the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it. After this partitioning, the pivot is in its final position.
3. Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.

![Backtracking IMG](QuickSort2.png)

## Quick Sort Complexity
 - Base and average time complexity - ***O(n log n)***
 - Worst case complexity - ***O(n^2)*** - occurs when the smallest or largest element is always chosen as the pivot.
 - Space complexity - ***O(log n)*** - due to the recursive calls.

## Sample Code
```java
public class QuickSort {
    
    // Function to partition the array on the basis of pivot element
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Main function that implements QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);  // Before pi
            quickSort(array, pi + 1, high); // After pi
        }
    }

    // Driver Code
    public static void main(String args[]) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        quickSort(array, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}

```

In this example, the last element of the array is always chosen as the pivot. The quickSort function is called recursively for sub-arrays, and the partition function is used to perform the partitioning. After sorting, the array is printed to the console.
