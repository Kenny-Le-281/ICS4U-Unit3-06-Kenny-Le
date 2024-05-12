/*
* Merge sorting
*
* @author  Kenny Le
* @version 1.0
* @since   2024-04-24
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

final class MergeSort {
  private MergeSort() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
  * The min number for array.
  */
  public static final int MIN = 0;
  /**
  * The max number for array.
  */
  public static final int MAX = 100;
  /**
  * The number of elements in the array.
  */
  public static final int ARRAY_SIZE = 100;

  public static int[] mergeSort(int[] array) {
        int mid = array.length / 2;

        if (array.length < 2) {
            return array;
        }

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

        return array;
    }


  
  public static void main(final String[] args) {
      // Initializing the random class
      Random randNumber = new Random();
    
      // Initializing array of numbers
      int[] randomNumberArray = new int[ARRAY_SIZE];
    
      // Adding numbers to the array
      for (int counter = 0; counter < randomNumberArray.length; counter++) {
        randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
      }

      int[] numberArray = randomNumberArray;

      System.out.println("Original array:\n" + Arrays.toString(numberArray));
      int[] newArray = mergeSort(numberArray);
      System.out.println("Sorted array:\n" + Arrays.toString(newArray));


  }
}
