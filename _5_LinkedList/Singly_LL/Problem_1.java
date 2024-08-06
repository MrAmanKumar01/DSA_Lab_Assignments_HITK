/*
1. Write a menu-driven program to implement a singly linked list with the following operations:
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
*/
package _5_LinkedList.Singly_LL;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    // Insert at front
    void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at any position
    void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertFront(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {   //following zero based indexing
            current = current.next;
        }
        if (current == null) {    //if list is shorter than the desired position
            System.out.println("Invalid position");
             return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete from front
    void deleteFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete from end
    void deleteEnd() {
        if (head == null) {  //Special case 1
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {  //Special case 2
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {   //will fetch 2nd last element
            current = current.next;
        }
        current.next = null;
    }

    // Delete at any position
    void deleteAtPosition(int position) {
        if (head == null) {   //Special case 1
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {   //Special case 2
            head = head.next; //head will move 1 index fwd
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) { //If "current" is null or "current.next" is null, it means that the target position is beyond the end of the list, and the position is invalid.
            System.out.println("Invalid position");
            return;
        }
        current.next = current.next.next;
    }

    // Display the list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Perform linear search
    boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Insert after a specified element
    void insertAfter(int key, int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a specified element
    void deleteElement(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Element not found");
            return;
        }
        current.next = current.next.next;
    }

    // Count the number of nodes
    int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Reverse the list
    void reverse() {
        Node prev = null;      // Initialize a reference to the previous node as null
        Node current = head;   // Start from the head of the list
        Node nextNode;         // Initialize a reference to the next node

        // Traverse the list until the current node becomes null
        while (current != null) {
            nextNode = current.next;   // Store the next node of the current node
            current.next = prev;       // Reverse the link of the current node to point to the previous node
            prev = current;            // Update the previous node reference to the current node
            current = nextNode;        // Move to the next node in the original list
        }

        head = prev;  // Update the head reference to point to the last node, which is now the first node in the reversed list
    }

    // Concatenate two lists
    void concatenate(SinglyLinkedList list) {
        if (head == null) {
            head = list.head;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        while (true) {
            System.out.println("1. Insert at front");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete from front");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from position");
            System.out.println("7. Display the list");
            System.out.println("8. Linear search");
            System.out.println("9. Insert after element");
            System.out.println("10. Delete element");
            System.out.println("11. Count nodes");
            System.out.println("12. Reverse the list");
            System.out.println("13. Concatenate lists");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int element1 = scanner.nextInt();
                    list.insertFront(element1);
                    break;
                case 2:
                    System.out.print("Enter element to insert: ");
                    int element2 = scanner.nextInt();
                    list.insertEnd(element2);
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
                    int element3 = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position3 = scanner.nextInt();
                    list.insertAtPosition(element3, position3);
                    break;
                case 4:
                    list.deleteFront();
                    break;
                case 5:
                    list.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int position6 = scanner.nextInt();
                    list.deleteAtPosition(position6);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.print("Enter element to search: ");
                    int key8 = scanner.nextInt();
                    System.out.println("Element found: " + list.search(key8));
                    break;
                case 9:
                    System.out.print("Enter element to insert: ");
                    int element9 = scanner.nextInt();
                    System.out.print("Enter element after which to insert: ");
                    int key9 = scanner.nextInt();
                    list.insertAfter(key9, element9);
                    break;
                case 10:
                    System.out.print("Enter element to delete: ");
                    int key10 = scanner.nextInt();
                    list.deleteElement(key10);
                    break;
                case 11:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 12:
                    list.reverse();
                    break;
                case 13:
                    SinglyLinkedList list2 = new SinglyLinkedList();
                    System.out.print("Enter number of elements in second list: ");
                    int n = scanner.nextInt();
                    System.out.print("Enter elements: ");
                    for (int i = 0; i < n; i++) {
                        int element = scanner.nextInt();
                        list2.insertEnd(element);
                    }
                    list.concatenate(list2);
                    break;
                case 14:
                    System.out.println("Exited");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

/*
OUTPUT:
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 1
Enter element to insert: 1
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 2
Enter element to insert: 2
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 2
Enter element to insert: 3
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 2
Enter element to insert: 4
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 7
1 2 3 4
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 12
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 7
4 3 2 1
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 11
Number of nodes: 4
1. Insert at front
2. Insert at end
3. Insert at position
4. Delete from front
5. Delete from end
6. Delete from position
7. Display the list
8. Linear search
9. Insert after element
10. Delete element
11. Count nodes
12. Reverse the list
13. Concatenate lists
14. Exit
Enter your choice: 14
Exited
*/
