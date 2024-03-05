/*
1. Write a program to implement a Queue class (use a list(to be done later after Arraylist concept)/array to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a
method to check two Queue are carrying similar elements or not. (Repetition of the
elements are not considered).
 */
package _4_Queue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// Custom exception for queue overflow
class Overflow extends Exception {
    public Overflow(String message) {
        super(message);
    }
}

// Custom exception for queue underflow
class Underflow extends Exception {
    public Underflow(String message) {
        super(message);
    }
}

class Queue {
    int[] arr;
    int maxSize;
    int rear;
    //Constructor
    Queue(int n) {
        arr = new int[n];
        this.maxSize = n;
        this.rear = -1;
    }

    //Empty
    boolean isEmpty() {
        return rear == -1;
    }

    //Full
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    //Add ( Enqueue )
    void add(int data) throws Overflow {
        if (isFull()) {
            throw new Overflow("Queue is full");
        }

        rear = rear + 1;
        arr[rear] = data;
    }

    //Remove
    int remove() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Queue is empty");
        }

        int front = arr[0];
        //shift elements 1 step forward towards index "0" i.e. "front" head --> Time Complexity increases here
        // Another implementation would have been moving the "front" head one step backward during each deletion --> but it would have
        // resulted in memory wastage i.e. high Space Complexity as we are using arrays
        for (int i=0; i<rear; i++) {
            arr[i] = arr[i+1];
        }

        rear = rear - 1;
        return front;
    }

    //Peek
    int peek() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Queue is empty");
        }

        return arr[0];
    }

    // Check similarity of two queues
//    commented out and not used this because we don't want equal maxSize constraint
//    boolean isSimilar(Queue otherQueue) {
//        if (this.rear != otherQueue.rear) {
//            return false;
//        }
//
//        //copies of arrays to preserve original state
//        int[] copy1 = this.arr.clone();
//        int[] copy2 = otherQueue.arr.clone();
//
//        // Sort arrays to compare without considering repetitions
//        java.util.Arrays.sort(copy1);
//        java.util.Arrays.sort(copy2);
//
//        // Compare arrays element by element
//        for (int i = 0; i <= this.rear; i++) {
//            if (copy1[i] != copy2[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    // Check similarity of two queues
    boolean isSimilar(Queue q) throws Underflow {
//        if (this.rear != otherQueue.rear) {    // ******* commented out because we don't want equal maxSize constraint  *******
//            return false;
//        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        while (!this.isEmpty()) {
            set1.add(this.remove());
        }
        System.out.println("Queue1: " + set1);
        while (!q.isEmpty()) {
            set2.add(q.remove());
        }
        System.out.println("Queue2: " + set2);

        // could also have used return set1.equals(set2) for below implementation.
        // It would have drastically reduced lines of code
        Iterator<Integer> i = set1.iterator();
        Iterator<Integer> j = set2.iterator();
        while (i.hasNext() || j.hasNext()) {       //O(n)
            if (set1.contains(j.next()) && set2.contains(i.next())) {
                continue;
            }
            return false;
        }
        return true;
    }
}

public class Problem_1 {
    public static void main(String[] args) throws Overflow, Underflow {
        Scanner sc = new Scanner(System.in);
//        Queue q = new Queue(4);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//
//        while (!q.isEmpty()) {
//            System.out.println(q.peek());
//            q.remove();
//        }
//
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.remove();
//        q.add(5);
//
//        while (!q.isEmpty()) {
//            System.out.println(q.peek());
//            q.remove();
//        }

        System.out.print("Enter the maxSize of first Queue: ");
        int n1 = sc.nextInt();
        Queue q1 = new Queue(n1);
        System.out.print("Insert elements in Queue1: ");
        for (int i=0; i<n1; i++) {
            q1.add(sc.nextInt());
        }

        System.out.println();

        System.out.print("Enter the maxSize of second Queue: ");
        int n2 = sc.nextInt();
        System.out.print("Insert elements in Queue2: ");
        Queue q2 = new Queue(n2);
        for (int i=0; i<n2; i++) {
            q2.add(sc.nextInt());
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
Enter the maxSize of first Queue: 3
Insert elements in Queue1: 1 2 3

Enter the maxSize of second Queue: 4
Insert elements in Queue2: 1 2 3 1
Queue1: [1, 2, 3]
Queue2: [1, 2, 3]
Queues contain similar elements (order and repetition doesn't matter)
--------------------------------------------------------------------------------
Enter the maxSize of first Queue: 4
Insert elements in Queue1: 1 2 3 1

Enter the maxSize of second Queue: 3
Insert elements in Queue2: 1 2 3
Queue1: [1, 2, 3]
Queue2: [1, 2, 3]
Queues contain similar elements (order and repetition doesn't matter)
--------------------------------------------------------------------------------
Enter the maxSize of first Queue: 5
Insert elements in Queue1: 1 2 3 4 2

Enter the maxSize of second Queue: 7
Insert elements in Queue2: 1 4 3 2 2 1 4
Queue1: [1, 2, 3, 4]
Queue2: [1, 2, 3, 4]
Queues contain similar elements (order and repetition doesn't matter)
*/
