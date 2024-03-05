/*
3. Write a menu driven program to implement a deque using list(to be done later)/array.
Call the two ends of the deque left and right and write four methods, remvLeft,
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right
ends of the deque. Make sure that the routines work properly for empty deque and
that they detect overflow and underflow conditions.
*/
package _4_Queue;

import java.util.Scanner;

class Deque {
    private int[] deque;
    private int maxSize;
    private int front;
    private int rear;

    public Deque(int maxSize) {
        deque = new int[maxSize];
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void insertLeft(int element) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert element at left.");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = maxSize - 1;
        } else {
            front = front - 1;
        }
        deque[front] = element;
        System.out.println("Inserted " + element + " at the left end of the deque.");
    }

    public void insertRight(int element) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert element at right.");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == maxSize - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        deque[rear] = element;
        System.out.println("Inserted " + element + " at the right end of the deque.");
    }

    public int removeLeft() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove element from left.");
            return -1;
        }
        int removed = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        return removed;
    }

    public int removeRight() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove element from right.");
            return -1;
        }
        int removed = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = maxSize - 1;
        } else {
            rear = rear - 1;
        }
        return removed;
    }

    public void displayDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.println("Elements of the deque:");
        int i = front;
        do {
            System.out.print(deque[i] + " ");
            i = (i + 1) % maxSize;
        } while (i != (rear + 1) % maxSize);
        System.out.println();
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maximum size of the deque: ");
        int maxSize = sc.nextInt();
        Deque deque = new Deque(maxSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert element at left");
            System.out.println("2. Insert element at right");
            System.out.println("3. Remove element from left");
            System.out.println("4. Remove element from right");
            System.out.println("5. Display deque");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at left: ");
                    int leftElement = sc.nextInt();
                    deque.insertLeft(leftElement);
                    break;
                case 2:
                    System.out.print("Enter element to insert at right: ");
                    int rightElement = sc.nextInt();
                    deque.insertRight(rightElement);
                    break;
                case 3:
                    int removedLeft = deque.removeLeft();
                    if (removedLeft != -1) {
                        System.out.println("Removed element from left: " + removedLeft);
                    }
                    break;
                case 4:
                    int removedRight = deque.removeRight();
                    if (removedRight != -1) {
                        System.out.println("Removed element from right: " + removedRight);
                    }
                    break;
                case 5:
                    deque.displayDeque();
                    break;
                case 6:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

/*
OUTPUT:
Enter the maximum size of the deque: 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 3
Deque is empty. Cannot remove element from left.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 4
Deque is empty. Cannot remove element from right.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 1
Enter element to insert at left: 1
Inserted 1 at the left end of the deque.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 2
Enter element to insert at right: 2
Inserted 2 at the right end of the deque.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
1 2

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 2
Enter element to insert at right: 3
Inserted 3 at the right end of the deque.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 2
Enter element to insert at right: 4
Inserted 4 at the right end of the deque.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
1 2 3 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 2
Enter element to insert at right: 5
Deque is full. Cannot insert element at right.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 1
Enter element to insert at left: 5
Deque is full. Cannot insert element at left.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
1 2 3 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 3
Removed element from left: 1

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
2 3 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 1
Enter element to insert at left: 5
Inserted 5 at the left end of the deque.

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
5 2 3 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 4
Removed element from right: 4

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 5
Elements of the deque:
5 2 3

Menu:
1. Insert element at left
2. Insert element at right
3. Remove element from left
4. Remove element from right
5. Display deque
6. Exit
Enter your choice: 6
Exited
*/
