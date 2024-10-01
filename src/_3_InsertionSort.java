/*
Algorithm for Insertion Sort:
1. Iterate from the second element to the end of the array.
2. For each element, compare it with the elements before it.
3. Shift all elements that are greater than the current element to the right.
4. Insert the current element into its correct position.
5. Repeat until the array is sorted.

Steps in detail:
1. Start with the second element (index 1) as the current element.
2. Compare the current element with the previous elements.
3. Shift all elements that are greater than the current element to the right.
4. Insert the current element into its correct position.
5. Move to the next element and repeat steps 2-4 until the end of the array.

Time Complexity:
- Best case: O(n) when the array is already sorted.
- Average and Worst case: O(n^2) when the array is not sorted.
*/

import java.util.Arrays;

public class _3_InsertionSort {
    // Function to sort an array using Insertion Sort
    public void insertionSort(int[] array) {
        // Loop through each element in the array starting from the second element
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // Store the current element
            int j = i - 1;

            // Shift elements of the array that are greater than the key to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key; // Place the key in its correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr)); // Print array before sorting
        _3_InsertionSort is = new _3_InsertionSort();
        is.insertionSort(arr); // Sort the array using Insertion Sort
        System.out.println(Arrays.toString(arr)); // Print array after sorting
    }
}