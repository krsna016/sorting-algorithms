/*
Algorithm for Heap Sort:
1. Build a max heap from the input array.
2. Swap the root (maximum value) of the heap with the last element of the heap.
3. Reduce the size of the heap by one and heapify the root element to maintain the max heap property.
4. Repeat steps 2 and 3 until the heap size is greater than 1.

Steps in detail:
1. Build a max heap:
   a. Start from the last non-leaf node and heapify each node up to the root.
2. Swap the root of the heap with the last element.
3. Reduce the heap size by one.
4. Heapify the root element to maintain the max heap property.
5. Repeat steps 2-4 until the heap is sorted.

Time Complexity:
- Best case: O(n log n) for all cases.
- Average and Worst case: O(n log n) for all cases.
*/

import java.util.Arrays;

public class _6_HeapSort {

    public void heapSort(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 12, 34, 55, 66, 245, 87, 9};
        System.out.println(Arrays.toString(arr));
        _6_HeapSort hs = new _6_HeapSort();
        hs.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
