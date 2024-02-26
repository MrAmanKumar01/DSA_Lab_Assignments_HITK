/*
5. Write a recursive function to find the sum of the following series.

(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
(b) S= 1^2- 3^2+ 5^2- 7^2+ + N (Input N).
(c) S= x3- x3/3 + x3/9 - x3/27 + x3/81 - x3/243 ....(Input X,N).
 */
package _3_Recursive_Function;

import java.util.Scanner;

public class Series {
    //	(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
    static int seriesa(int n) {
        n= (n%2==0)? n:n-1;
        if(n==2)
            return n;
        return n+seriesa(n-2);
    }
    //	(b) S= 1^2- 3^2+ 5^2- 7^2+ + N (Input N).
    static int seriesb(int n) {
        if(n==1)
            return 1;
        return (-(int)Math.pow(-1,n))*(int)Math.pow((2*n-1),2)+ seriesb(n-1);
    }

    //	(c) S= x3- x3/3 + x3/9 - x3/27 + x3/81 - x3/243 ....(Input X,N).
    static double seriesc(double x, double n) {
        if(n==0)
            return Math.pow(x, 3);
        return Math.pow(-1,n)*Math.pow(x,3)/Math.pow(3, n) + seriesc(x,n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for (a) ");
        System.out.println(seriesa(sc.nextInt()));
        System.out.println("Enter the number for (b) ");
        System.out.println(seriesb(sc.nextInt()));
        System.out.println("Enter the numbers for (c) ");
        System.out.println(seriesc(sc.nextInt(), sc.nextInt()));
        sc.close();
    }
}

/*
OUTPUT:
Enter the number for (a)
10
30
Enter the number for (b)
7
97
Enter the numbers for (c)
5
2
97.22222222222223
*/



