/*
7. Create a program with multi-dimensional List to store customer details
(customerId,customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
- Create a constructor to initialize size of customer details for five customers.
- Create customer method which takes the array of customer elements (sorted as a
customerName).
- Create a method to getCustomer(customerId) method which will return the customer
details as a List.
- Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city.
*/

package _1_Arrays;

import java.util.Arrays;

class Customer{
    int size;
    String[][] s = new String[size][3];
    Customer(String[][]s) {
        size = 5;
        this.s =s;
    }
    void customer() {
        for(int i =1; i<s.length;i++) {
            int j = i;
            while(j>0 && s[j][1].compareTo(s[j-1][1])<0) {
                String [] temp = s[j];
                s[j] = s[j-1];
                s[j-1] = temp;
                j--;
            }
        }
    }

    private int binarySearch(String ele, int r, int l) {
        int m = (l+r)/2;
        if(s[m][0].compareTo(ele)==0)
            return m;
        if(r<l)
            return -1;
        if(s[m][0].compareTo(ele)<0) {
            return binarySearch(ele,r,m+1);
        }else {
            return binarySearch(ele,m-1,l);
        }
    }

    String[] getCustomer(String customerId){
        for(int i =1; i<s.length;i++) {
            int j = i;
            while(j>0 && s[j][0].compareTo(s[j-1][0])<0) {
                String [] temp = s[j];
                s[j] = s[j-1];
                s[j-1] = temp;
                j--;
            }
        }
        int n = binarySearch(customerId,0,size-1);
        String[] dummy = {"dummy"};
        if(n==-1)
            return dummy;
        return s[n];
    }

    String[][] sortCustomer(){
        for(int i =1; i<s.length;i++) {
            int j = i;
            while(j>0 && s[j][2].compareTo(s[j-1][2])<0) {
                String [] temp = s[j];
                s[j] = s[j-1];
                s[j-1] = temp;
                j--;
            }
        }
        return s;
    }
}

public class Problem_7 {
    public static void main(String[] args) {
        String[][] s = {
                {"1003","Aman","Durgapur"},
                {"1001","Abhik","Bankura"},
                {"1000","Prabhud","Bangalore"},
                {"1004","Sakshi","Raygadh"},
                {"1002","Kiara","Patna"}
        };
        Customer c = new Customer(s);
        String [] arr = c.getCustomer("1002");
        System.out.println(Arrays.toString(arr));
    }
}

/*
OUTPUT:
[1002, Kiara, Patna]
*/








