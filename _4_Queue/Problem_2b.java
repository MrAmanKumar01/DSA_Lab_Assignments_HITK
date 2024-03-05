/*
2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes: (a) A circular list with front and rear indices and
one position left vacant. Or, (b) A circular list with front and rear indices and an integer
variable counting entries.
***Solve using Scheme (b),
Scheme (b) Circular list with front and rear indices and an integer variable counting entries:
- In this scheme, the circular queue also uses an array with front and rear indices to keep track of the elements.
- Additionally, an integer variable is used to count the number of entries in the queue.
- When the queue is empty, both front and rear indices are set to -1, and the entry count is 0.
- When an element is enqueued, the rear index is incremented circularly, and the element is added to the rear index.
- When an element is dequeued, the front index is incremented circularly, and the entry count is decremented.
- This approach allows for a more direct tracking of the number of elements in the queue.
 */

package _4_Queue;

import java.util.Scanner;

class CircularQueueScheme2 {
    private int[] arr;
    private int maxSize;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public CircularQueueScheme2(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == maxSize;
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
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued successfully.");
        System.out.print("No. of elements in Queue: " + size);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removed = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        size--;
        System.out.println("No. of elements in Queue: " + size);
        return removed;
    }

    // Display the queue elements
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        int i = front;
        int count = 0;
        while (count < size) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % maxSize;
            count++;
        }
        System.out.println();
    }
}

public class Problem_2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum size of the circular queue: ");
        int maxSize = sc.nextInt();

        CircularQueueScheme2 queue = new CircularQueueScheme2(maxSize);

        int choice;
        do {
            System.out.println("\nCircular Queue Menu:");
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
                    queue.enqueue(data);
                    break;
                case 2:
                    int removed = queue.dequeue();
                    if (removed != -1) {
                        System.out.println("Dequeued element: " + removed);
                    }
                    break;
                case 3:
                    queue.displayQueue();
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
Enter the maximum size of the circular queue: 3

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 1
1 enqueued successfully.
No. of elements in Queue: 1
Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 2
2 enqueued successfully.
No. of elements in Queue: 2
Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 3
3 enqueued successfully.
No. of elements in Queue: 3
Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 1
Enter the element to enqueue: 4
Queue is full. Cannot enqueue.

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 3
Queue: 1 2 3

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 2
No. of elements in Queue: 2
Dequeued element: 1

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 2
No. of elements in Queue: 1
Dequeued element: 2

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 2
No. of elements in Queue: 0
Dequeued element: 3

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 2
Queue is empty. Cannot dequeue.

Circular Queue Menu:
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit
Enter your choice: 4
Exited
*/
