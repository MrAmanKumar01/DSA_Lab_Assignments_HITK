/*
1. Write a program to implement a stack using linked list, such that the operations ‘push’
and ‘pop’ are performed in constant time.
*/
package _5_LinkedList.Applications;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public Stack() {
        this.top = null;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push operation: Add an element to the top of the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation: Remove and return the element at the top of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1; // Or throw an exception
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Peek operation: Return the element at the top of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }
        return top.data;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the top element of the stack
        System.out.println("Top element of the stack: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Trying to pop from an empty stack
        System.out.println("Popped element: " + stack.pop());
    }
}

/*
OUTPUT:
Top element of the stack: 30
Popped element: 30
Popped element: 20
Popped element: 10
Stack underflow
Popped element: -1
*/
