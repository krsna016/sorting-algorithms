/*
Algorithm for Shell Sort:

1. Start with a large gap and reduce the gap until it becomes 1.
2. For each gap, perform a gapped insertion sort:
   a. Pick an element and compare it with the element at the gap distance.
   b. Swap if necessary and continue comparing and swapping until the correct position is found.
3. Repeat the process for the next element in the array.
4. Reduce the gap and repeat steps 2-3 until the gap is 1.
5. Perform a final insertion sort with a gap of 1 to ensure the array is fully sorted.

Steps in detail:
1. Initialize the gap to half the length of the array.
2. Perform a gapped insertion sort for each gap:
   a. For each element from the gap to the end of the array:
      i. Store the element in a temporary variable.
      ii. Compare the element with the elements at the gap distance.
      iii. Shift the elements if necessary and place the stored element in its correct position.
3. Reduce the gap and repeat until the gap is 1.
4. Perform a final insertion sort with a gap of 1.

Time Complexity:
- Best case: O(n log n) when the array is already nearly sorted.
- Average case: O(n^(3/2)) for most gap sequences.
- Worst case: O(n^2) for the worst gap sequence.
*/

public class _9_ShellSort {

    // Function to sort an array using Shell Sort
    public void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // A utility function to print an array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        _9_ShellSort ss = new _9_ShellSort();
        System.out.println("Array before sorting:");
        printArray(arr);

        ss.shellSort(arr);

        System.out.println("Array after sorting:");
        printArray(arr);
    }
}

