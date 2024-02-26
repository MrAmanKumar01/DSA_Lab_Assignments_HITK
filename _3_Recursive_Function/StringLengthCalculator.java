/*
8. Write a Program to calculate the length of the string using a recursive function.
*/
package _3_Recursive_Function;

public class StringLengthCalculator {

    public static int calculateLength(String str) {
        // Base case: if the string is empty, return 0
        if (str.isEmpty()) {
            return 0;
        }
        // Recursive case: return 1 plus the length of the string without the first character
        return 1 + calculateLength(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "AMAN KUMAR";
        int length = calculateLength(str);
        System.out.println("Length of the string '" + str + "' is: " + length);
    }
}

/*
OUTPUT:
Length of the string 'AMAN KUMAR' is: 10
*/
