/*
4. Write a recursive function to calculate the sum of all digits of a number entered by the user.
*/
package _3_Recursive_Function;

import java.util.Scanner;
public class Digit_Sum {
    int sum = 0;
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number:");
        n = s.nextInt();
        Digit_Sum obj = new Digit_Sum();
        int a = obj.add(n);
        System.out.println("Sum:"+a);
        s.close();
    }
    int add(int n) {
        sum = n % 10;
        if(n == 0)
        {
            return 0;
        }
        else
        {
            return sum + add(n / 10);
        }
    }
}

/*
OUTPUT:
Enter the number: 12345
Sum:15
-------------------------------
Enter the number:78913
Sum:28
*/
