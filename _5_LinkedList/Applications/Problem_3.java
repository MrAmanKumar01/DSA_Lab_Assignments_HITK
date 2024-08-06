/*
3. Write a menu driven program to implement a double ended queue using linked list.
*/
package _5_LinkedList.Applications;

import java.util.Scanner;

class Node1 {
    int data;
    Node1 prev;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Deque {
    private Node1 front;
    private Node1 rear;

    public Deque() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void insertFront(int data) {
        Node1 newNode = new Node1(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        System.out.println("Element inserted at the front: " + data);
    }

    public void insertRear(int data) {
        Node1 newNode = new Node1(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        System.out.println("Element inserted at the rear: " + data);
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        } else {
            int data = front.data;
            if (front == rear) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }
            System.out.println("Element deleted from the front: " + data);
            return data;
        }
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        } else {
            int data = rear.data;
            if (front == rear) {
                front = null;
                rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
            System.out.println("Element deleted from the rear: " + data);
            return data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Deque elements:");
        Node1 current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque deque = new Deque();

        while (true) {
            System.out.println("\n------ Double Ended Queue Menu ------");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at Rear");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from Rear");
            System.out.println("5. Display Deque");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            int data;

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    data = scanner.nextInt();
                    deque.insertFront(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert at rear: ");
                    data = scanner.nextInt();
                    deque.insertRear(data);
                    break;
                case 3:
                    data = deque.deleteFront();
                    if (data != -1) {
                        System.out.println("Deleted element from front: " + data);
                    }
                    break;
                case 4:
                    data = deque.deleteRear();
                    if (data != -1) {
                        System.out.println("Deleted element from rear: " + data);
                    }
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}

/*
OUTPUT:
------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 1
Enter data to insert at front: 1
Element inserted at the front: 1

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 2
Enter data to insert at rear: 2
Element inserted at the rear: 2

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 2
Enter data to insert at rear: 3
Element inserted at the rear: 3

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 2
Enter data to insert at rear: 4
Element inserted at the rear: 4

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 5
Deque elements:
1 2 3 4

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 3
Element deleted from the front: 1
Deleted element from front: 1

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 3
Element deleted from the front: 2
Deleted element from front: 2

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 5
Deque elements:
3 4

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 4
Element deleted from the rear: 4
Deleted element from rear: 4

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 5
Deque elements:
3

------ Double Ended Queue Menu ------
1. Insert at Front
2. Insert at Rear
3. Delete from Front
4. Delete from Rear
5. Display Deque
6. Exit
Enter your choice: 6
Exiting the program...
*/