/*
2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
*/
package _5_LinkedList.DoublyAndCircularLL;

import java.util.Scanner;

class LNode {
    int data;
    LNode prev;
    LNode next;

    LNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyCircularLinkedList {
    LNode head;

    // Method to insert a LNode at the front of the list
    void insertFront(int data) {
        LNode newLNode = new LNode(data);
        if (head == null) {
            newLNode.next = newLNode;
            newLNode.prev = newLNode;
            head = newLNode;
            return;
        }
        newLNode.next = head;
        newLNode.prev = head.prev;
        head.prev.next = newLNode;
        head.prev = newLNode;
        head = newLNode;
    }

    // Method to insert a LNode at the end of the list
    void insertEnd(int data) {
        LNode newLNode = new LNode(data);
        if (head == null) {
            newLNode.next = newLNode;
            newLNode.prev = newLNode;
            head = newLNode;
            return;
        }
        newLNode.next = head;
        newLNode.prev = head.prev;
        head.prev.next = newLNode;
        head.prev = newLNode;
    }

    // Method to insert a LNode after a given LNode
    void insertAfter(LNode prevLNode, int data) {
        if (prevLNode == null) {
            System.out.println("Previous LNode cannot be null");
            return;
        }
        LNode newLNode = new LNode(data);
        newLNode.next = prevLNode.next;
        prevLNode.next.prev = newLNode;
        prevLNode.next = newLNode;
        newLNode.prev = prevLNode;
    }

    // Method to delete a LNode from the list
    void deleteLNode(LNode del) {
        if (head == null || del == null)
            return;
        if (head == del && head.next == head) {
            head = null;
            return;
        }
        if (head == del)
            head = del.next;
        del.prev.next = del.next;
        del.next.prev = del.prev;
    }

    // Method to display the list
    void displayList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        LNode temp = head;
        System.out.print("Doubly circular linked list: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class DCLList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyCircularLinkedList doublyCircularLinkedList = new DoublyCircularLinkedList();

        char choice;
        do {
            System.out.println("\nDoubly Circular Linked List Operations:");
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
                    doublyCircularLinkedList.insertFront(frontData);
                    break;
                case 'b':
                    System.out.print("Enter the element to insert at the end: ");
                    int endData = scanner.nextInt();
                    doublyCircularLinkedList.insertEnd(endData);
                    break;
                case 'c':
                    System.out.print("Enter the element to insert after: ");
                    int afterData = scanner.nextInt();
                    System.out.print("Enter the element to insert: ");
                    int insertData = scanner.nextInt();
                    LNode prevLNode = doublyCircularLinkedList.head;
                    while (prevLNode != null && prevLNode.data != afterData)
                        prevLNode = prevLNode.next;
                    if (prevLNode == null)
                        System.out.println(afterData + " not found in the list.");
                    else
                        doublyCircularLinkedList.insertAfter(prevLNode, insertData);
                    break;
                case 'd':
                    System.out.print("Enter the element to delete: ");
                    int deleteData = scanner.nextInt();
                    LNode delLNode = doublyCircularLinkedList.head;
                    while (delLNode != null && delLNode.data != deleteData)
                        delLNode = delLNode.next;
                    if (delLNode == null)
                        System.out.println(deleteData + " not found in the list.");
                    else
                        doublyCircularLinkedList.deleteLNode(delLNode);
                    break;
                case 'e':
                    doublyCircularLinkedList.displayList();
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
Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: a
Enter the element to insert at the front: 10

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: d
Enter the element to delete: 10

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: a
Enter the element to insert at the front: 10

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: b
Enter the element to insert at the end: 20

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: a
Enter the element to insert at the front: 30

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: e
Doubly circular linked list: 30 10 20

Doubly Circular Linked List Operations:
a. Insert an element at the front
b. Insert an element at the end
c. Insert an element after a specified element
d. Delete an element
e. Display the list
f. Exit
Enter your choice: f
Exiting program...
 */

