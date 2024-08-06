package _7_Sorting_Algorithms;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int [] arr){
        int max = 0;
        for(int i : arr)
            if(i>max)
                max = i;
        for(int exp = 1; max/exp > 0; exp*=10){
            countSort(arr, exp);
        }
    }
    public static void countSort(int[] arr, int exp){
        int n = arr.length;
        int [] output = new int[n];
        int []count = new int[10];
        for(int i =0; i<n ; i++){
            int r = (arr[i]/exp) % 10;
            count[r]++;
        }
        for(int i =1; i<10; i++){
            count[i] += count[i-1];
        }
        for(int i =n-1; i>=0; i--){
            int r = (arr[i]/exp) % 10;
            int position = count[r] -1;
            output[position] = arr[i];
            count[r]-=1;
        }
        for(int i =0; i<n; i++)
            arr[i] = output[i];
    }
    public static void main(String[] args) {
        int [] arr = {123,43,56,43,23,33,56,56,98,98,75};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
