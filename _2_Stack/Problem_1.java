/*
1. Write a program to implement a Stack class (use a Array to store the elements of the stack).
[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to
check two stack are carrying similar elements or not.(Repetition of the elements are not
considered)
*/
package _2_Stack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Overflow extends Exception {
    Overflow (String s) {   //exception message
        super(s);
    }
}

class Underflow extends Exception {
    Underflow (String s) {   //exception message
        super(s);
    }
}

class Stack {
    private int[] arr;
    private int top;

    //Constructor
    Stack (int size) {
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int data) throws Overflow {
        if (isFull()) {
            throw new Overflow("Stack Overflow");
        }
        arr[++top] = data;
    }

    public int pop() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Stack Underflow");
        }
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

//    Difference b/w pop() and peek() here is pop()
//    reduces the top index but peek just peeks the top anytime

    public int size() {
        return top + 1;   //because top was initialized with -1
    }
    public static boolean compareStacks(Stack stack1, Stack stack2) throws Underflow, Overflow {
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        //special case
        if (stack1.isEmpty() || stack2.isEmpty()) {
            System.out.println("Stack is empty from start, please push some elements to compare");
            return false;
        }
        while (!stack1.isEmpty()) {  //O(n)
            h1.add(stack1.pop());
        }
        System.out.println("h1: " + h1);
        while (!stack2.isEmpty()) {   //O(n)
            h2.add(stack2.pop());
        }
        System.out.println("h2: " + h2);

        /* We can use this also instead of Iterator and while loop as below:  ***
        boolean isEqual = h1.equals(h2);
        System.out.println(isEqual);
        return isEqual; */

        Iterator<Integer> i = h1.iterator();
        while (i.hasNext()) {       //O(n)
            if (h2.contains(i.next())) {
                continue;
            }
            return false;
        }
        return true;
    }
}

public class Problem_1 {
    public static void main(String[] args) throws Overflow, Underflow {
//        int n1, n2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Stack1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the size of Stack2: ");
        int n2 = sc.nextInt();
        Stack s1 = new Stack(n1);
        Stack s2 = new Stack(n2);
        System.out.println("Enter the elements in Stack1: ");
        for (int i=0; i<n1; i++) {
            s1.push(sc.nextInt());
        }
        System.out.println("Enter the elements in Stack2: ");
        for (int i=0; i<n2; i++) {
            s2.push(sc.nextInt());
        }
//        s1.push(10);
//        s1.push(20);
//        s1.push(30);
//        s1.push(40);
//        s1.push(5);

//        s2.push(10);
//        s2.push(20);
//        s2.push(30);
//        s2.push(40);
//        s2.push(50);

        if (Stack.compareStacks(s1, s2)) {
            System.out.println("Stacks contain similar elements (order doesn't matter)");
        } else {
            System.out.println("Stacks do not contain similar elements");
        }
    }
}

/*
OUTPUT:
Enter the size of Stack1: 5
Enter the size of Stack2: 5
Enter the elements in Stack1:
10 20 30 0 0
Enter the elements in Stack2:
10 20 30 20 10
h1: [0, 20, 10, 30]
h2: [20, 10, 30]
Stacks do not contain similar elements
-------------------------------------------------
Enter the size of Stack1: 4
Enter the size of Stack2: 5
Enter the elements in Stack1:
5 30 20 10
Enter the elements in Stack2:
10 20 30 10 20
h1: [20, 5, 10, 30]
h2: [20, 10, 30]
Stacks do not contain similar elements
------------------------------------------------------
Enter the size of Stack1: 4
Enter the size of Stack2: 5
Enter the elements in Stack1:
10 20 30 40
Enter the elements in Stack2:
10 40 20 30 40
h1: [20, 40, 10, 30]
h2: [20, 40, 10, 30]
Stacks contain similar elements (order doesn't matter)
*/
