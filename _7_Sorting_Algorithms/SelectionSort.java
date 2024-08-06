package _7_Sorting_Algorithms;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int turn = 0; turn < arr.length-1; turn++) {
            int minPos = turn;
            for (int j = turn + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            //swap
            int temp = arr[turn];
            arr[turn] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void selectionSortDescending(int[] arr) {
        for (int turn=0; turn< arr.length-1; turn++) {
            int minPos = turn;
            for (int j=turn+1; j<arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[turn];
            arr[turn] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("Sorted array is: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        int[] arr2 = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        selectionSort(arr);
        printArray(arr);

        selectionSortDescending(arr);
        printArray(arr);

        selectionSortDescending(arr2);
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
