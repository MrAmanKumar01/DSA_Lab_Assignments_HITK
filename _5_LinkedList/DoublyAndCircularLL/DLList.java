/*
1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
*/
package _5_LinkedList.DoublyAndCircularLL;

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        Node last = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (last.next != null)
            last = last.next;
        last.next = newNode;
        newNode.prev = last;
    }

    void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    void deleteNode(Node del) {
        if (head == null || del == null)
            return;
        if (head == del)
            head = del.next;
        if (del.next != null)
            del.next.prev = del.prev;
        if (del.prev != null)
            del.prev.next = del.next;
    }
    void displayList() {
        Node temp = head;
        System.out.print("Doubly linked list: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DLList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        char choice;
        do {
            System.out.println("\nDoubly Linked List Operations:");
            System.out.println("a. Insert an element at the front");
            System.out.println("b. Insert an element at the end");
            System.out.println("c. Insert an element after a specified element");
            System.out.println("d. Delete an element");
            System.out.println("e. Display the list");
            System.out.println("f. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 'a':
                    System.out.print("Enter the element to insert at the front: ");
                    int frontData = scanner.nextInt();
                    doublyLinkedList.insertFront(frontData);
                    break;
                case 'b':
                    System.out.print("Enter the element to insert at the end: ");
                    int endData = scanner.nextInt();
                    doublyLinkedList.insertEnd(endData);
                    break;
                case 'c':
                    System.out.print("Enter the element to insert after: ");
                    int afterData = scanner.nextInt();
                    System.out.print("Enter the element to insert: ");
                    int insertData = scanner.nextInt();
                    Node prevNode = doublyLinkedList.head;
                    while (prevNode != null && prevNode.data != afterData)
                        prevNode = prevNode.next;
                    if (prevNode == null)
                        System.out.println(afterData + " not found in the list.");
                    else
                        doublyLinkedList.insertAfter(prevNode, insertData);
                    break;
                case 'd':
                    System.out.print("Enter the element to delete: ");
                    int deleteData = scanner.nextInt();
                    Node delNode = doublyLinkedList.head;
                    while (delNode != null && delNode.data != deleteData)
                        delNode = delNode.next;
                    if (delNode == null)
                        System.out.println(deleteData + " not found in the list.");
                    else
                        doublyLinkedList.deleteNode(delNode);
                    break;
                case 'e':
                    doublyLinkedList.displayList();
                    break;
                case 'f':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 'f');

        scanner.close();
    }
}

//Output:
/*
Doubly Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: a
Enter the element to insert at the front: 10

Doubly Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: a
Enter the element to insert at the front: 20

Doubly Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: b
Enter the element to insert at the end: 30

Doubly Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: e
Doubly linked list: 20 10 30

Doubly Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: f
 */

