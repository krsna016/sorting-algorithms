/*
Algorithm for Radix Sort:

1. Find the maximum number in the array to determine the number of digits.
2. Perform counting sort for each digit, starting from the least significant digit to the most significant digit.
3. Use a stable counting sort to sort the digits.

Steps in detail:
1. Find the maximum number to determine the number of digits.
2. Initialize the count array for each digit (0 to 9).
3. For each digit, do the following:
   a. Count the occurrences of each digit in the array.
   b. Modify the count array to get the positions of digits.
   c. Place the elements in the output array based on the current digit.
   d. Copy the sorted elements back to the input array.

Time Complexity:
- Best case: O(n \* k) where n is the number of elements and k is the number of digits.
- Average and Worst case: O(n \* k) where n is the number of elements and k is the number of digits.
*/

public class _8_RadixSort {

    // A utility function to get the maximum value in an array
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int[] count = new int[10];
        for (int i = 0; i < 10; i++)
            count[i] = 0;

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to the current digit
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using Radix Sort
    static void radixSort(int[] arr, int n) {
        // Find the maximum number to know the number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead of passing the digit number, exp is passed. exp is 10^i where i is the current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        printArray(arr, n);
        radixSort(arr, n);
        printArray(arr, n);
    }
}


