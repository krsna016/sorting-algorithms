/*
Algorithm for Bubble Sort:

1. Start at the beginning of the array.
2. Compare each pair of adjacent elements.
3. If the elements are in the wrong order, swap them.
4. Move to the next pair of elements and repeat step 3 until the end of the array.
5. Repeat steps 1-4 for the entire array until no swaps are needed (the array is sorted).

Steps in detail:
1. Initialize a boolean variable swapped to true.
2. While swapped is true:
   a. Set swapped to false.
   b. For each pair of adjacent elements in the array:
      i. If the first element is greater than the second element, swap them and set swapped to true.
3. If no elements were swapped in the inner loop, the array is sorted.

Time Complexity:
- Best case: O(n) when the array is already sorted.
- Average and Worst case: O(n^2) when the array is not sorted.
 */

import java.util.Arrays;

public class _1_BubbleSort {
    // Function to sort an array using Bubble Sort
    public void bubbleSort(int[] array) {
        // Loop through each element in the array
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false; // Initialize swapped to false

            // Compare adjacent elements and swap if they are in the wrong order
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Set swapped to true
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr)); // Print array before sorting
        _1_BubbleSort bs = new _1_BubbleSort();
        bs.bubbleSort(arr); // Sort the array using Bubble Sort
        System.out.println(Arrays.toString(arr)); // Print array after sorting

    }
}