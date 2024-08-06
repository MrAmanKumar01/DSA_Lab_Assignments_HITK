/*
2. Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.
*/
package _5_LinkedList.Applications;

//class Node {
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}

class LinkedListQueue {
    private Node front;
    private Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Or throw an exception
        }
        int removedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Update rear when dequeueing the last element
        }
        return removedData;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements and print them
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue remaining elements and print them
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Try dequeueing from an empty queue
        System.out.println("Dequeued element: " + queue.dequeue());
    }
}

/*
OUTPUT:
Dequeued element: 10
Dequeued element: 20
Dequeued element: 30
Dequeued element: 40
Dequeued element: 50
Queue is empty
Dequeued element: -1
*/
