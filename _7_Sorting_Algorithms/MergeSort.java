package _7_Sorting_Algorithms;

public class MergeSort {
    //sorting method (to do step1(divide) & step2(sort parts))
    public static void mergeSort(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si)/2; // or = (si + ei) / 2;
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid+1, ei); // right part

        merge(arr, si, mid, ei);
        printArr(arr); //just to show changes in original array
    }

    //merge method to merge the sorted parts
    public static void merge(int[] arr, int si, int mid, int ei) {
        // left(0,2)=3 & right(3,5)=3 -> 5-0+1 = 6
        int[] temp = new int[ei-si+1];
        int i = si; //idx for 1st sorted part(left)
        int j = mid+1; //idx for 2nd sorted part(right)
        int k = 0; //idx for temp;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //for leftover elements (if any) of 1st sorted part(left)
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        //for leftover elements (if any) of 2nd sorted part(right)
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy temp to original array
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
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
        mergeSort(arr, 0, arr.length-1);
        System.out.print("Sorted array: ");
        printArr(arr);
    }
}

/*
OUTPUT:
3 6 9 5 2 8
3 6 9 5 2 8
3 6 9 2 5 8
3 6 9 2 5 8
2 3 5 6 8 9
Sorted array: 2 3 5 6 8 9
----------------------------
-1 8 6 -9 4 11 14 -3
-1 8 -9 6 4 11 14 -3
-9 -1 6 8 4 11 14 -3
-9 -1 6 8 4 11 14 -3
-9 -1 6 8 4 11 -3 14
-9 -1 6 8 -3 4 11 14
-9 -3 -1 4 6 8 11 14
Sorted array: -9 -3 -1 4 6 8 11 14
 */