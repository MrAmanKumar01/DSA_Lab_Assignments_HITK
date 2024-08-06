/*
1. Write functions to implement a solution to Towers of Hanoi problem. Check your
program with number of disks = 0, 1, 2 and 3.
*/

/*
For aiding in making Recursion tree *****
from  --> source
to  --> destination
aux --> auxiliary

//inner calls
#1. from = from   //source fixed
    to = aux
    aux = to

#2. from = aux
    to = to       //destination fixed
    aux = from
*/
package _6_Recursion_and_Tree;

import java.util.Scanner;

public class Tower_Of_Hanoi {
    private static void hanoi(int n, char from, char to, char aux) {
        //special case
        if(n ==  0) {
            System.out.println("No disks to be moved");
            return;
        }
        //Base case
        if (n == 1) {
            System.out.printf("Move disk %d from %c to %c", n, from, to);
            System.out.println();
        } else {
            hanoi(n-1, from, aux, to);    //#1 --> left branch in recursion tree
            System.out.printf("Move disk %d from %c to %c", n, from, to);  // n printing --> nth disk destination
            System.out.println();
            hanoi(n-1, aux, to, from);  //#2  --> right branch in recursion tree
        }
    }

    public static void main(String[] args) {
//        int n = 3;  //no. of disks
        System.out.print("Enter number of disks: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char from = 'A';  //source
        char aux = 'B';   //auxiliary
        char to = 'C';   //destination

        hanoi(n, from, to, aux);
    }
}

/*
OUTPUT:
Enter number of disks: 0
No disks to be moved
------------------------------------------
Enter number of disks: 1
Move disk 1 from A to C
------------------------------------------
Enter number of disks: 2
Move disk 1 from A to B
Move disk 2 from A to C
Move disk 1 from B to C
------------------------------------------
Enter number of disks: 3
Move disk 1 from A to C
Move disk 2 from A to B
Move disk 1 from C to B
Move disk 3 from A to C
Move disk 1 from B to A
Move disk 2 from B to C
Move disk 1 from A to C
*/
