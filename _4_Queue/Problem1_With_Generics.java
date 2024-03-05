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

class BasicQueue<T> {
    T[] arr;
    int maxSize;
    int rear;

    // Constructor
    BasicQueue(int n) {
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
            throw new Overflow2("BasicQueue is full");
        }

        rear++;
        arr[rear] = data;
    }

    // Remove
    T remove() throws Underflow2 {
        if (isEmpty()) {
            throw new Underflow2("BasicQueue is empty");
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
            throw new Underflow2("BasicQueue is empty");
        }

        return arr[0];
    }

    // Check similarity of two queues
    boolean isSimilar(BasicQueue<T> q) throws Underflow2 {
        HashSet<T> set1 = new HashSet<>();
        HashSet<T> set2 = new HashSet<>();

        while (!this.isEmpty()) {
            set1.add(this.remove());
        }
        System.out.println("BasicQueue1: " + set1);
        while (!q.isEmpty()) {
            set2.add(q.remove());
        }
        System.out.println("BasicQueue2: " + set2);

        return set1.equals(set2);
    }
}

public class Problem1_With_Generics {
    public static void main(String[] args) throws Overflow2, Underflow2 {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Enter the maxSize of first BasicQueue: ");
//        int n1 = sc.nextInt();
//        BasicQueue<Integer> q1 = new BasicQueue<>(n1);
//        System.out.print("Insert elements in BasicQueue1: ");
//        for (int i = 0; i < n1; i++) {
//            q1.add(sc.nextInt());
//        }
//
//        System.out.println();
//
//        System.out.print("Enter the maxSize of second BasicQueue: ");
//        int n2 = sc.nextInt();
//        System.out.print("Insert elements in BasicQueue2: ");
//        BasicQueue<Integer> q2 = new BasicQueue<>(n2);
//        for (int i = 0; i < n2; i++) {
//            q2.add(sc.nextInt());
//        }
//
//        if (q1.isSimilar(q2)) {
//            System.out.println("BasicQueues contain similar elements (order and repetition doesn't matter)");
//        } else {
//            System.out.println("BasicQueues do not contain similar elements");
//        }

        System.out.print("Enter the maxSize of first BasicQueue: ");
        int n1 = sc.nextInt();
        BasicQueue<String> q1 = new BasicQueue<>(n1);
        System.out.print("Insert elements in BasicQueue1: ");
        for (int i = 0; i < n1; i++) {
            q1.add(sc.next());
        }

        System.out.println();

        System.out.print("Enter the maxSize of second BasicQueue: ");
        int n2 = sc.nextInt();
        System.out.print("Insert elements in BasicQueue2: ");
        BasicQueue<String> q2 = new BasicQueue<>(n2);
        for (int i = 0; i < n2; i++) {
            q2.add(sc.next());
        }

        if (q1.isSimilar(q2)) {
            System.out.println("BasicQueues contain similar elements (order and repetition doesn't matter)");
        } else {
            System.out.println("BasicQueues do not contain similar elements");
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
Enter the maxSize of first BasicQueue: 3
Insert elements in BasicQueue1: AMAN RANVIR ABHISHEK

Enter the maxSize of second BasicQueue: 4
Insert elements in BasicQueue2: RANVIR ABHISHEK AMAN RANVIR
BasicQueue1: [RANVIR, AMAN, ABHISHEK]
BasicQueue2: [RANVIR, AMAN, ABHISHEK]
BasicQueues contain similar elements (order and repetition doesn't matter)
------------------------------------------------------------------------------------
Enter the maxSize of first BasicQueue: 3
Insert elements in BasicQueue1: AMAN RANVIR ABHISHEK

Enter the maxSize of second BasicQueue: 4
Insert elements in BasicQueue2: RANVIR ABHISHEK AMAN RAMAN
BasicQueue1: [RANVIR, AMAN, ABHISHEK]
BasicQueue2: [RANVIR, AMAN, RAMAN, ABHISHEK]
BasicQueues do not contain similar elements
*/