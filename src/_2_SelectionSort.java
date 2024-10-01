/*
Algorithm for Selection Sort:

1. Iterate through the array.
2. For each position in the array, find the smallest element in the unsorted portion of the array.
3. Swap the smallest element with the element at the current position.
4. Move to the next position and repeat until the entire array is sorted.

Steps in detail:
1. Start with the first element as the current position.
2. Find the smallest element in the array from the current position to the end.
3. Swap the smallest element with the element at the current position.
4. Move to the next position and repeat steps 2-3 until the end of the array.

Time Complexity:
- Best case: O(n^2) when the array is already sorted.
- Average and Worst case: O(n^2) when the array is not sorted.
*/

import java.util.Arrays;

public class _2_SelectionSort {
    // Function to sort an array using Selection Sort
    public void selectionSort(int[] array) {
        // Loop through each element in the array
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // Initialize the minimum index to the current position

            // Find the smallest element in the unsorted portion of the array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Update the minimum index if a smaller element is found
                }
            }

            // Swap the smallest element with the element at the current position
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr)); // Print array before sorting
        _2_SelectionSort ss = new _2_SelectionSort();
        ss.selectionSort(arr); // Sort the array using Selection Sort
        System.out.println(Arrays.toString(arr)); // Print array after sorting
    }
}