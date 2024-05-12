/*
* This program uses a method to find where disks should be placed.
*
* @author  Kenny Le
* @version 1.0
* @since   2024-04-24
*/

import java.util.Arrays;

/**
* This program uses merge sorting
*/
final class MergeSorting {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private MergeSorting() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Formats an array of integers.
     *
     * @param array to be formatted
     * @return the formatted array as a string
     */
    static String formatArray(int[] array) {
        String formattedArray = "";

        for (int counter = 0; counter < array.length; counter++) {
            if (counter == array.length - 1) {
                formattedArray = formattedArray + array[counter];
            } else {
                formattedArray = formattedArray + array[counter] + ",";
            }
        }

        return formattedArray;
    }

    /**
     * Removes the first element of an array.
     *
     * @param array the array to have the first element removed
     * @return the new array
     */
    static int[] removeFirst(int[] array) {
        final int[] newArray = new int[array.length - 1];
        for (int counter = 1; counter < array.length; counter++) {
            newArray[counter - 1] = array[counter];
        }

        return newArray;
    }

    /**
     * Pushes an element to an array.
     *
     * @param array the array to have the new element
     * @param newElement the new element of the array
     * @return the new array
     */
    static int[] push(int[] array, int newElement) {
        final int[] newArray = new int[array.length + 1];

        for (int counter = 0; counter < array.length; counter++) {
            newArray[counter] = array[counter];
        }

        newArray[array.length] = newElement;

        return newArray;
    }

    /**
     * Merges two arrays together.
     *
     * @param left the array to the left
     * @param right the array to the right
     * @return the merged array
     */
    static int[] merge(int[] left, int[] right) {
        int[] sortArray = {};
        int[] otherLeft = left;
        int[] otherRight = right;

        while (otherLeft.length > 0 && otherRight.length > 0) {
            if (otherLeft[0] < otherRight[0]) {
                sortArray = push(sortArray, otherLeft[0]);
                otherLeft = removeFirst(otherLeft);
            } else {
                sortArray = push(sortArray, otherRight[0]);
                otherRight = removeFirst(otherRight);
            }
        }

        for (int counter = 0; counter < otherLeft.length; counter++) {
            sortArray = push(sortArray, otherLeft[counter]);
        }
        for (int counter = 0; counter < otherRight.length; counter++) {
            sortArray = push(sortArray, otherRight[counter]);
        }

        return sortArray;
    }

    /**
     * Sorts an array using the merging sorting algorithm.
     *
     * @param sortArray the array to be sorted
     * @return the sorted array
     */
    static int[] mergeSort(int[] sortArray) {
        final int mid = sortArray.length / 2;
        final int[] sortedArray;

        if (sortArray.length < 2) {
            sortedArray = sortArray;
        } else {
            final int[] left = Arrays.copyOfRange(sortArray, 0, mid);
            final int[] right = Arrays.copyOfRange(
                sortArray, mid, sortArray.length
            );
            sortedArray = merge(mergeSort(left), mergeSort(right));
        }

        return sortedArray;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // Array constants
        final int[] array = {-1, 4, 10, 5, 18, 225, 900, -80, -6, -9};
        final int[] sortedArray = mergeSort(array);

        // Show unsorted array
        System.out.println("Unsorted array: " + formatArray(array) + "\n");

        // Show sorted array
        System.out.println("Sorted array: " + formatArray(sortedArray));

        // Show the program as done
        System.out.println("\nDone.");
    }
}
