package _7_Sorting_Algorithms;

public class InsertionSort {
    public static void insertionSort(int[] arr) {  // O(n^2)
        for (int i=1; i<arr.length; i++) {
            int curr = arr[i]; // element being compared is stored in temporary variable
            int prev = i-1;
            // finding out the correct position to insert by sequentially comparing and shifting
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion ***
            // After coming out of while loop, insertion idx is reduced by 1
            // that's why "prev+1" to regain correct insertion index(place)
            arr[prev+1] = curr;
        }
    }

    public static void insertionSortDescending(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] < curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev+1] = curr;
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("Sorted array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        int[] arr2 = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        insertionSort(arr);
        printArray(arr);

        insertionSortDescending(arr);
        printArray(arr);

        insertionSortDescending(arr2);
        printArray(arr2);
    }
}

/*
OUTPUT:
Sorted array is:
1 2 3 4 5
Sorted array is:
5 4 3 2 1
Sorted array is:
8 7 6 5 4 3 3 2 1 1
*/

