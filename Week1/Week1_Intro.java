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
