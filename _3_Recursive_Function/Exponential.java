/*
3. Write a recursive function to calculate the power of a two number(consider the degree as a
negative/positive integer).
*/
package _3_Recursive_Function;

public class Exponential{
    public static void main(String[] args)
    {
        int base=3,exponent=4;
        int result=power(base,exponent);

        System.out.println("Power of " + base + " raised to the power of " + exponent +", Result: "+result);
    }
    static int power(int base,int exponent)
    {
        if(exponent!=0)
        {
            return(base*power(base,exponent-1));
        }
        else
            return 1;

    }
}

/*
OUTPUT:
Power of 3 raised to the power of 4, Result: 81
*/