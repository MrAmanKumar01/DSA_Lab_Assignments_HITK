/*
1. Create a Class Search within that implement two Generic method LinearSearch(),
BinarySearch(). Test your program for different data
 */

package _1_Arrays;

class Search<T extends Comparable<T>> {

    public int linearSearch(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(key) == 0) {
                return i; // Key found at index i
            }
        }
        return -1; // Key not found
    }

    public int binarySearch(T[] array, T key) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cmp = array[mid].compareTo(key);

            if (cmp == 0) {
                return mid; // Key found at index mid
            } else if (cmp < 0) {
                start = mid + 1; // Key may be in the right half
            } else {
                end = mid - 1; // Key may be in the left half
            }
        }

        return -1; // Key not found
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Search<Integer> integerSearch = new Search<>();
        Integer[] intArray = {2, 4, 6, 8, 10, 12, 14};
        int result = integerSearch.linearSearch(intArray, 12);
        System.out.println("Linear Search Result: " + result);
        result = integerSearch.binarySearch(intArray, 12);
        System.out.println("Binary Search Result: " + result);

        Search<String> stringSearch = new Search<>();
        String[] strArray = {"dosa", "paneer", "rasmalai", "oats", "grape"};
        result = stringSearch.linearSearch(strArray, "oats");
        System.out.println("Linear Search Result: " + result);
        result = stringSearch.binarySearch(strArray, "rasmalai");
        System.out.println("Binary Search Result: " + result);
    }
}

/*
OUTPUT:
Linear Search Result: 5
Binary Search Result: 5
Linear Search Result: 3
Binary Search Result: 2
*/
