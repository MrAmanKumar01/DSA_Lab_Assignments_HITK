/*
2. Create a Class BasicSort within that implement three Generic methods that can implement the
BubbleSort(), SelectionSort(), InsertionSort() that can sort any type of data.
*/
package _1_Arrays;

class BasicSort<T extends Comparable<T>> {
    public void bubbleSort(T[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-1-i; j++) {
                //swap
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, i, i+1);
                    swapped = true;
                }
                if (!swapped) {
                    break;
                }
            }
        }
    }

    public void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos].compareTo(arr[j]) > 0) {
                    minPos = j;
                }
            }
            //swap
            swap(arr, i, minPos);
        }
    }

    public void insertionSort(T[] arr) {
        for (int i=1; i<arr.length; i++) {
            T curr = arr[i]; // element being compared is stored in temporary variable
            int prev = i-1;
            // finding out the correct position to insert by sequentially comparing and shifting
            while (prev >= 0 && arr[prev].compareTo(curr) > 0) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion ***
            // After exiting from while loop insertion index is reduced by 1 index
            // that's why "prev+1" to regain correct insertion index
            arr[prev+1] = curr;
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArr = {5, 2, 8, 1, 3};
        BasicSort<Integer> intSort = new BasicSort<>();

        intSort.bubbleSort(intArr);
        System.out.print("Bubble sort: ");
        for (Integer num : intArr) {
            System.out.print(num + ", ");
        }
        System.out.println();

        intSort.selectionSort(intArr);
        System.out.print("Selection sort: ");
        for (Integer num : intArr) {
            System.out.print(num + ", ");
        }
        System.out.println();

        intSort.insertionSort(intArr);
        System.out.print("Insertion sort: ");
        for (Integer num : intArr) {
            System.out.print(num + ", ");
        }
        System.out.println();

        // Test with String array
        String[] strArr = {"dosa", "paneer", "rasmalai", "oats", "grape"};
        BasicSort<String> strSort = new BasicSort<>();

        strSort.bubbleSort(strArr);
        System.out.print("Bubble sort: ");
        for (String str : strArr) {
            System.out.print(str + ", ");
        }
        System.out.println();

        strSort.selectionSort(strArr);
        System.out.print("Selection sort: ");
        for (String str : strArr) {
            System.out.print(str + ", ");
        }
        System.out.println();

        strSort.insertionSort(strArr);
        System.out.print("Insertion sort: ");
        for (String str : strArr) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}

/*
OUTPUT:
Bubble sort: 1, 2, 3, 5, 8,
Selection sort: 1, 2, 3, 5, 8,
Insertion sort: 1, 2, 3, 5, 8,
Bubble sort: dosa, grape, oats, paneer, rasmalai,
Selection sort: dosa, grape, oats, paneer, rasmalai,
Insertion sort: dosa, grape, oats, paneer, rasmalai,
*/