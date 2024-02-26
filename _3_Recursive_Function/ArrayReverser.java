/*
7. Write a Program to reverse an array using a recursive function.
*/
package _3_Recursive_Function;

import java.util.Arrays;

public class ArrayReverser {

    public static void reverseArray(int[] array) {
        reverseArrayHelper(array, 0, array.length - 1);
    }

    private static void reverseArrayHelper(int[] array, int start, int end) {
        if (start >= end) {
            return; // Base case: if start index is greater than or equal to end index, stop recursion
        }

        // Swap elements at start and end indices
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        // Recursively reverse the remaining subarray
        reverseArrayHelper(array, start + 1, end - 1);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {9, 8, 7, 5, 7, 4};
        System.out.println("Original array: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}

/*
OUTPUT:
Original array: [1, 2, 3, 4, 5]
Reversed array: [5, 4, 3, 2, 1]
---------------------------------------
Original array: [9, 8, 7, 5, 7, 4]
Reversed array: [4, 7, 5, 7, 8, 9
*/
