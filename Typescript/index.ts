/*
* This program uses a method to find where disks should be placed.
*
* @author  Kenny Le
* @version 1.0
* @since   2024-05-4
*/

function mergeSort(array: number[]): number[] {
  if (array.length <= 1) {
    return array
  }

  // Split the array into two halves
  const middle = Math.floor(array.length / 2)
  const leftHalf = array.slice(0, middle)
  const rightHalf = array.slice(middle)

  // Recursively sort both halves
  const sortedLeft = mergeSort(leftHalf)
  const sortedRight = mergeSort(rightHalf)

  // Merge the sorted halves
  return merge(sortedLeft, sortedRight)
}

function merge(left: number[], right: number[]): number[] {
  let result: number[] = []
  let leftIndex = 0
  let rightIndex = 0

  // Merge the two arrays by comparing elements
  while (leftIndex < left.length && rightIndex < right.length) {
    if (left[leftIndex] < right[rightIndex]) {
      result.push(left[leftIndex])
      leftIndex++
    } else {
      result.push(right[rightIndex])
      rightIndex++
    }
  }

  // Add any remaining elements from the left array
  while (leftIndex < left.length) {
    result.push(left[leftIndex])
    leftIndex++
  }

  // Add any remaining elements from the right array
  while (rightIndex < right.length) {
    result.push(right[rightIndex])
    rightIndex++
  }

  return result
}

// Example usage:
const array: number[] = [3, 4, 8, 10, 9, 7, 1]
const sortedArray: number[] = mergeSort(array)

// Prints orginal array
console.log(`The original array is: ${array}`)

// Prints sorted array
console.log(`The sorted array is: ${sortedArray}`)

// Prints done
console.log('\nDone.')
