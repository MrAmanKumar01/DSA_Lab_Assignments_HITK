/*
3. Write a Generic method that computes the Second minimum and Second maximum elements
of an array of type T and returns a pair containing the minimum and maximum value.
*/
package _1_Arrays;

class SecondMinMax<T extends Comparable<T>> {
    public Pair<T, T> findSecondMinMax(T[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        T min = array[0];
        T max = array[0];
        T secondMin = null;
        T secondMax = null;

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                secondMin = min;
                min = array[i];
            } else if (secondMin == null || (array[i].compareTo(secondMin) < 0 && !array[i].equals(min))) {
                secondMin = array[i];
            }

            if (array[i].compareTo(max) > 0) {
                secondMax = max;
                max = array[i];
            } else if (secondMax == null || (array[i].compareTo(secondMax) > 0 && !array[i].equals(max))) {
                secondMax = array[i];
            }
        }

        return new Pair<>(secondMin, secondMax);
    }
    static class Pair<U, V> {
        U first;
        V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        SecondMinMax<Integer> secondMinMax = new SecondMinMax<>();
        Integer[] intArray = {5, 8, 2, 10, 15, 1, 3};
        SecondMinMax.Pair<Integer, Integer> result = secondMinMax.findSecondMinMax(intArray);
        System.out.println("Second minimum: " + result.first);
        System.out.println("Second maximum: " + result.second);
    }
}
/*
OUTPUT:
Second minimum: 2
Second maximum: 10
*/