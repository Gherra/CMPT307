package Week1;



public class Week1_Intro {
    /**
     * Helper method to print an array.
     * @param array The array to be printed.
     */
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Performs Insertion Sort on the given array.
     *
     * Input:
     * - A 0-based array `array` of length `n`, containing numeric elements.
     *
     * Output:
     * - The array such that for all `0 ≤ i < j < n`, `array[i] ≤ array[j]`.
     *
     * Loop Invariant:
     * - At the start of the `j`th iteration (j from 1..n-1),
     *   the subarray `array[0..j-1]` is sorted and contains the elements
     *   originally in `array[0..j-1]` but in sorted order.
     *
     * Proof of Correctness:
     * 1. Initialization:
     *    - Prior to the first iteration (when j = 1), `array[0..0]` has one element
     *      and is trivially sorted. This matches the 1-based pseudocode's statement
     *      "A[1..1] is sorted."
     *
     * 2. Maintenance:
     *    - Assume for iteration `j-1`, the subarray `array[0..(j-1)-1]` is sorted.
     *    - In iteration `j`, we:
     *      a) Store `array[j]` in a temp variable `tmp`.
     *      b) Shift elements that are greater than `tmp` one position to the right.
     *      c) Insert `tmp` into the correct position.
     *    - Thus, after this step, `array[0..j]` is sorted and still contains the
     *      same elements it did originally.
     *
     * 3. Termination:
     *    - When `j` reaches `n`, we have processed all elements.
     *    - By the invariant, `array[0..n-1]` is sorted.
     *
     * Complexity:
     * - Best Case: O(n) when the array is already sorted.
     * - Worst Case: O(n²) when the array is sorted in reverse order (or nearly so).
     * - Space Complexity: O(1) (in-place sorting).
     *
     * @param array The integer array to be sorted.
     */
    public static void insertionSort(int[] array) {
        // Traverse from the second element (index 1) to the end
        for (int j = 1; j < array.length; j++) {
            int tmp = array[j]; // The element to be inserted
            int i = j - 1;      // Start comparing with the last element in the sorted subarray [0..j-1]

            // Shift elements of [0..j-1] that are greater than tmp to the right
            while (i >= 0 && array[i] > tmp) {
                array[i + 1] = array[i];
                i--;
            }

            // Place `tmp` into its correct (now vacant) position
            array[i + 1] = tmp;
            /* Explanation:
             * After the while loop, `i` has been decremented past all elements
             * that were greater than `tmp`. Thus, `i + 1` is the correct index
             * for `tmp` in the sorted portion [0..j].
             */
        }
    }

    public static void main(String[] args) {
        // Initialize the array
        int[] array = {2, 4, 1, 5, 3, 6};

        // Print the original array
        System.out.println("Original Array:");
        printArray(array);

        // Perform Insertion Sort
        System.out.println("\nArray after Insertion Sort:");
        insertionSort(array);
        printArray(array);
    }
}
