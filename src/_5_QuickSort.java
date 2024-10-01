/*
Algorithm for Quick Sort:

1. Choose a pivot element from the array.
2. Partition the array into two halves:
   a. Elements less than the pivot.
   b. Elements greater than or equal to the pivot.
3. Recursively apply the above steps to the two halves.
4. Combine the sorted halves to get the final sorted array.

Steps in detail:
1. If the array has one or no elements, it is already sorted.
2. Choose a pivot element (commonly the last element).
3. Partition the array such that elements less than the pivot are on the left, and elements greater than or equal to the pivot are on the right.
4. Recursively apply quickSort to the left and right halves.
5. Combine the sorted halves to get the final sorted array.

Time Complexity:
- Best case: O(n log n) when the pivot elements divide the array into two equal halves.
- Average case: O(n log n) due to the probabilistic nature of the pivot selection.
- Worst case: O(n^2) when the pivot elements are the smallest or largest elements.
*/

import java.util.Arrays;

public class _5_QuickSort {

    // Function to sort an array using Quick Sort
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Helper function to partition the array
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the last element as pivot
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partitioning index
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr)); // Print array before sorting
        _5_QuickSort qs = new _5_QuickSort();
        qs.quickSort(arr, 0, arr.length - 1); // Sort the array using Quick Sort
        System.out.println(Arrays.toString(arr)); // Print array after sorting
    }
}