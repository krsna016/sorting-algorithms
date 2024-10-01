/*
Algorithm for Merge Sort:

1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves to produce the sorted array.

Steps in detail:
1. If the array has one or no elements, it is already sorted.
2. Find the middle point to divide the array into two halves.
3. Call mergeSort for the first half.
4. Call mergeSort for the second half.
5. Merge the two halves using a helper function merge.

The merge function:
1. Create temporary arrays to hold the two halves.
2. Compare the elements of the two halves and copy the smaller element to the original array.
3. Copy any remaining elements of the temporary arrays to the original array.

Time Complexity:
- Best case: O(n log n) for all cases.
- Average and Worst case: O(n log n) for all cases.
*/

import java.util.Arrays;

public class _4_MergeSort {

    // Function to sort an array using Merge Sort
    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2; // Find the middle point

            // Recursively sort the first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Helper function to merge two halves
    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1; // Size of the left subarray
        int n2 = right - middle; // Size of the right subarray

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];

        // Merge the temporary arrays

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr)); // Print array before sorting
        _4_MergeSort ms = new _4_MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1); // Sort the array using Merge Sort
        System.out.println(Arrays.toString(arr)); // Print array after sorting
    }
}

