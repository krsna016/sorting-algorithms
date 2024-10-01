/*
Algorithm for Counting Sort:
1. Find the maximum value in the array to determine the range of the count array.
2. Create a count array of size (maximum value + 1) and initialize it with zeros.
3. Count the occurrences of each element in the input array and store the counts in the count array.
4. Modify the count array by adding the previous counts to get the positions of elements in the sorted array.
5. Create an output array to store the sorted elements.
6. Place the elements from the input array into their correct positions in the output array using the count array.
7. Copy the sorted elements from the output array back to the input array.

Steps in detail:
1. Find the maximum value in the array.
2. Initialize the count array with zeros.
3. Count the occurrences of each element.
4. Modify the count array to get the positions.
5. Place the elements in the output array.
6. Copy the sorted elements back to the input array.

Time Complexity:
- Best case: O(n + k) where n is the number of elements and k is the range of the input.
- Average and Worst case: O(n + k) where n is the number of elements and k is the range of the input.
*/

import java.util.Arrays;

public class _7_CountingSort {
    public void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        // Count the occurrences of each element
        for (int i : arr) {
            count[i]++;
        }

        // Modify the count array to get the positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place the elements in the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements back to the input array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 9, 7, 1, 2, 4};
        _7_CountingSort cs = new _7_CountingSort();
        System.out.println(Arrays.toString(arr));
        cs.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
