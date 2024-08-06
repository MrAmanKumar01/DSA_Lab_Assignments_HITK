/*
1. Write a program to implement a Queue class (use a list to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a
method to check two Queue are carrying similar elements or not. (Repetition of the
elements are not consider)
 */
package _4_Queue;

import java.util.HashSet;
import java.util.Scanner;

// Custom exception for queue overflow
class Overflow2 extends Exception {
    public Overflow2(String message) {
        super(message);
    }
}

// Custom exception for queue underflow
class Underflow2 extends Exception {
    public Underflow2(String message) {
        super(message);
    }
}

class SimpleQueue<T> {
    T[] arr;
    int maxSize;
    int rear;

    // Constructor
    SimpleQueue(int n) {
        arr = (T[]) new Object[n];
        this.maxSize = n;
        this.rear = -1;
    }

    // Empty
    boolean isEmpty() {
        return rear == -1;
    }

    // Full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // Add (Enqueue)
    void add(T data) throws Overflow2 {
        if (isFull()) {
            throw new Overflow2("Queue is full");
        }

        rear++;
        arr[rear] = data;
    }

    // Remove
    T remove() throws Underflow2 {
        if (isEmpty()) {
            throw new Underflow2("Queue is empty");
        }

        T front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        return front;
    }

    // Peek
    T peek() throws Underflow2 {
        if (isEmpty()) {
            throw new Underflow2("Queue is empty");
        }

        return arr[0];
    }

    // Check similarity of two queues
    boolean isSimilar(SimpleQueue<T> q) throws Underflow2 {
        HashSet<T> set1 = new HashSet<>();
        HashSet<T> set2 = new HashSet<>();

        while (!this.isEmpty()) {
            set1.add(this.remove());
        }
        System.out.println("Queue1: " + set1);
        while (!q.isEmpty()) {
            set2.add(q.remove());
        }
        System.out.println("Queue2: " + set2);

        return set1.equals(set2);
    }
}

public class Problem1_With_Generics {
    public static void main(String[] args) throws Overflow2, Underflow2 {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Enter the maxSize of first Queue: ");
//        int n1 = sc.nextInt();
//        SimpleQueue<Integer> q1 = new SimpleQueue<>(n1);
//        System.out.print("Insert elements in Queue1: ");
//        for (int i = 0; i < n1; i++) {
//            q1.add(sc.nextInt());
//        }
//
//        System.out.println();
//
//        System.out.print("Enter the maxSize of second Queue: ");
//        int n2 = sc.nextInt();
//        System.out.print("Insert elements in Queue2: ");
//        SimpleQueue<Integer> q2 = new SimpleQueue<>(n2);
//        for (int i = 0; i < n2; i++) {
//            q2.add(sc.nextInt());
//        }
//
//        if (q1.isSimilar(q2)) {
//            System.out.println("Queues contain similar elements (order and repetition doesn't matter)");
//        } else {
//            System.out.println("Queues do not contain similar elements");
//        }

        System.out.print("Enter the maxSize of first Queue: ");
        int n1 = sc.nextInt();
        SimpleQueue<String> q1 = new SimpleQueue<>(n1);
        System.out.print("Insert elements in Queue1: ");
        for (int i = 0; i < n1; i++) {
            q1.add(sc.next());
        }

        System.out.println();

        System.out.print("Enter the maxSize of second Queue: ");
        int n2 = sc.nextInt();
        System.out.print("Insert elements in Queue2: ");
        SimpleQueue<String> q2 = new SimpleQueue<>(n2);
        for (int i = 0; i < n2; i++) {
            q2.add(sc.next());
        }

        if (q1.isSimilar(q2)) {
            System.out.println("Queues contain similar elements (order and repetition doesn't matter)");
        } else {
            System.out.println("Queues do not contain similar elements");
        }

    }
}

/*
OUTPUT:
Enter the maxSize of first Queue: 5
Insert elements in Queue1: 1 2 3 4 2

Enter the maxSize of second Queue: 7
Insert elements in Queue2: 1 4 3 2 2 1 4
Queue1: [1, 2, 3, 4]
Queue2: [1, 2, 3, 4]
Queues contain similar elements (order and repetition doesn't matter)
-------------------------------------------------------------------------------
Enter the maxSize of first Queue: 3
Insert elements in Queue1: AMAN RANVIR ABHISHEK

Enter the maxSize of second Queue: 4
Insert elements in Queue2: RANVIR ABHISHEK AMAN RANVIR
Queue1: [RANVIR, AMAN, ABHISHEK]
Queue2: [RANVIR, AMAN, ABHISHEK]
Queues contain similar elements (order and repetition doesn't matter)
------------------------------------------------------------------------------------
Enter the maxSize of first Queue: 3
Insert elements in Queue1: AMAN RANVIR ABHISHEK

Enter the maxSize of second Queue: 4
Insert elements in Queue2: RANVIR ABHISHEK AMAN RAMAN
Queue1: [RANVIR, AMAN, ABHISHEK]
Queue2: [RANVIR, AMAN, RAMAN, ABHISHEK]
Queues do not contain similar elements
*/