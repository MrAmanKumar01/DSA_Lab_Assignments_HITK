/*
1. Write a recursive function to calculate the gcd of two numbers.
*/
package _3_Recursive_Function;

public class GCD {

    public static void main(String[] args) {
        int n1 = 600, n2 = 60;
        int hcf = hcf(n1, n2);

        System.out.println("G.C.D is "+hcf);
    }

    public static int hcf(int n1, int n2)
    {
        if (n2 != 0)
            return hcf(n2, n1 % n2);
        else
            return n1;
    }
}

/*
OUTPUT:
G.C.D is 60
*/