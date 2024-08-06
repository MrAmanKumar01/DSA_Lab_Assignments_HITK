package _7_Sorting_Algorithms;

public class QuickSort {
    public static void quickSort(int[] arr, int si, int ei) {
        //base case
        if(si >= ei) {
            return;
        }

        //last element in array as pivot
        //pIdx variable stores correct index for pivot element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);  // left
        quickSort(arr, pIdx+1, ei);  // right
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; // makes space for elements smaller than pivot

        for(int j=si; j<ei; j++) {
            if(arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //place pivot at correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[ei]; // --> arr[i] = pivot;
        arr[ei] = temp; //pivot's position need to change so (pivot = temp) won't work

        return i;
    }

    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] arr = {6, 3, 9, 5, 2, 8};
        int[] arr = {-1, 8, 6, -9, 4, 11, 14, -3};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}

/*
OUTPUT:
2 3 5 6 8 9
-------------------------
-9 -3 -1 4 6 8 11 14
*/