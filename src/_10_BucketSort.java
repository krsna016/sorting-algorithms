/*
Algorithm for Bucket Sort:

1. Create an array of empty buckets.
2. Scatter the elements of the input array into the buckets.
3. Sort each non-empty bucket.
4. Concatenate the sorted buckets to form the sorted array.

Steps in detail:
1. Determine the number of buckets and create an array of empty buckets.
2. Scatter the elements:
   a. For each element in the input array, determine the appropriate bucket.
   b. Insert the element into the corresponding bucket.
3. Sort each non-empty bucket using a suitable sorting algorithm (e.g., insertion sort).
4. Concatenate the sorted elements from all buckets back into the input array.

Time Complexity:
- Best case: O(n + k) where n is the number of elements and k is the number of buckets.
- Average case: O(n + k) where n is the number of elements and k is the number of buckets.
- Worst case: O(n^2) when all elements are placed in a single bucket.
*/

import java.util.ArrayList;
import java.util.Collections;

public class _10_BucketSort {
    // Function to sort an array using Bucket Sort
    public void bucketSort(int[] arr, int bucketCount) {
        if (arr.length <= 1) return;

        // Create an array of empty buckets
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Determine the range of the input array
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // Scatter the elements into the buckets
        for (int num : arr) {
            int bucketIndex = Math.min((num - min) / ((max - min + 1) / bucketCount), bucketCount - 1);
            buckets[bucketIndex].add(num);
        }

        // Sort each non-empty bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate the sorted buckets
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // A utility function to print an array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};
        int bucketCount = 5;
        _10_BucketSort bs = new _10_BucketSort();
        System.out.println("Array before sorting:");
        printArray(arr);

        bs.bucketSort(arr, bucketCount);

        System.out.println("Array after sorting:");
        printArray(arr);
    }
}
