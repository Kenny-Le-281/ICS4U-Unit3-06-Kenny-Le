/*
* This program uses a method to find where disks should be placed.
*
* @author  Kenny Le
* @version 1.0
* @since   2024-04-24
*/

import java.util.Arrays;

/**
 * This class implements the Merge Sort algorithm to sort an array of integers.
 */
public class MergeSort {

    /**
     * Sorts the given array using the Merge Sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Split the array into two halves
        // The Arrays.copyOfRange() function in Java creates a new array 
        // containing a specified range of elements from an original array
        int middle = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middle);
        int[] rightHalf = Arrays.copyOfRange(array, middle, array.length);

        // Recursively sort both halves
        int[] sortedLeft = mergeSort(leftHalf);
        int[] sortedRight = mergeSort(rightHalf);

        // Merge the sorted halves
        return merge(sortedLeft, sortedRight);
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param left  the left sorted array
     * @param right the right sorted array
     * @return the merged sorted array
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Merge the two arrays by comparing elements
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Add any remaining elements from the left array
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        // Add any remaining elements from the right array
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of MergeSort class.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] array = {3, 4, 8, 10, 9, 7, 1};
        int[] sortedArray = mergeSort(array);

        // Prints original array
        System.out.println("The original array is: " + Arrays.toString(array));

        // Prints sorted array
        System.out.println("The sorted array is: " + Arrays.toString(sortedArray));

        // Prints done
        System.out.println("\nDone.");
    }
}
