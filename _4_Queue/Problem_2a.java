/*
2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes: (a) A circular list with front and rear indices and
one position left vacant. Or, (b) A circular list with front and rear indices and an integer
variable counting entries.
***Solved using Scheme (a),
Scheme (a) Circular list with front and rear indices and one position left vacant:
- In this scheme, the circular queue uses an array with front and rear indices to keep track of the elements.
- One position is left vacant to differentiate between the empty and full conditions of the queue.
- When the queue is empty, both front and rear indices point to the same position.
- When an element is enqueued, the rear index is incremented circularly, and the element is added to the rear index.
- When an element is dequeued, the front index is incremented circularly, and the element at the front index is removed.
- This approach simplifies the condition checking for full and empty queues.
*/
package _4_Queue;

import java.util.Scanner;

class CircularQueueScheme1 {
    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;

    // Constructor
    public CircularQueueScheme1(int maxSize) {
        queue = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // Enqueue operation
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
//        System.out.println("Dequeued: " + data);
        return data;
    }

    // Display the elements of the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        do {
            System.out.print(queue[i] + " ");
            i = (i + 1) % maxSize;
        } while (i != (rear + 1) % maxSize);
        System.out.println();
    }
}

public class Problem_2a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the circular queue: ");
        int maxSize = sc.nextInt();
        CircularQueueScheme1 circularQueue = new CircularQueueScheme1(maxSize);

        int choice;
        do {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int data = sc.nextInt();
                    circularQueue.enqueue(data);
                    break;
                case 2:
                    int dequeued = circularQueue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued element: " + dequeued);
                    }
                    break;
                case 3:
                    circularQueue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        sc.close();
    }
}

/*
OUTPUT:
Enter the size of the circular queue: 3

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 2
Queue is empty. Cannot dequeue.

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 1
Enqueued: 1

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 2
Enqueued: 2

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 3
Enqueued: 3

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 4
Exiting the program.
*/


