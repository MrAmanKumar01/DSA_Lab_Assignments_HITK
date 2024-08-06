/*
3. Write a program to construct a Binary Search Tree (BST) and perform the following
a. Traverse the tree in preorder, inorder, postorder and levelorder
b. Count the number of nodes
c. Count the number of leaves
d. Find the height of the tree
e. Search for an item in the tree
f. Remove a node from the tree
*/

package _6_Recursion_and_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node in BST
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }

    // Method to traverse the tree in Preorder
    public void preorderTraversal() {
        System.out.println("Preorder Traversal:");
        preorderHelper(root);
        System.out.println();
    }

    private void preorderHelper(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderHelper(root.left);
            preorderHelper(root.right);
        }
    }


    // Method to traverse the tree in Inorder
    public void inorderTraversal() {
        System.out.println("Inorder Traversal:");
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(TreeNode root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.val + " ");
            inorderHelper(root.right);
        }
    }

    // Method to traverse the tree in Postorder
    public void postorderTraversal() {
        System.out.println("Postorder Traversal:");
        postorderHelper(root);
        System.out.println();
    }

    private void postorderHelper(TreeNode root) {
        if (root != null) {
            postorderHelper(root.left);
            postorderHelper(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Method to traverse the tree in Levelorder
    public void levelorderTraversal() {
        System.out.println("Levelorder Traversal:");
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        System.out.println();
    }

    // Method to count the number of nodes
    public int countNodes() {
        return countNodesHelper(root);
    }

    private int countNodesHelper(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodesHelper(root.left) + countNodesHelper(root.right);
    }

    // Method to count the number of leaves
    public int countLeaves() {
        return countLeavesHelper(root);
    }

    private int countLeavesHelper(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeavesHelper(root.left) + countLeavesHelper(root.right);
    }

    // Method to find the height of the tree
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = getHeightHelper(root.left);
        int rightHeight = getHeightHelper(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to search for an item in the tree
    public boolean search(int val) {
        return searchHelper(root, val);
    }

    private boolean searchHelper(TreeNode root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        if (val < root.val)
            return searchHelper(root.left, val);
        else
            return searchHelper(root.right, val);
    }

    // Method to remove a node from the tree
    public void remove(int val) {
        root = removeHelper(root, val);
    }

    private TreeNode removeHelper(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val < root.val)
            root.left = removeHelper(root.left, val);
        else if (val > root.val)
            root.right = removeHelper(root.right, val);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.val = minValue(root.right);
            root.right = removeHelper(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minVal = root.val;
        while (root.left != null) {
            minVal = root.left.val;
            root = root.left;
        }
        return minVal;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting elements into the tree
//        bst.insert(50);
//        bst.insert(30);
//        bst.insert(20);
//        bst.insert(40);
//        bst.insert(70);
//        bst.insert(60);
//        bst.insert(80);
        System.out.print("Enter no. of elements you want to insert: ");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for (int i=0; i<n; i++) {
            bst.insert(sc.nextInt());
        }

        // Performing different operations on the tree
        bst.preorderTraversal();
        bst.inorderTraversal();
        bst.postorderTraversal();
        bst.levelorderTraversal();

        System.out.println("Number of nodes: " + bst.countNodes());
        System.out.println("Number of leaves: " + bst.countLeaves());
        System.out.println("Height of the tree: " + bst.getHeight());

        System.out.print("Enter the element you want to search for: ");
        int searchKey = sc.nextInt();
        System.out.println("Is " + searchKey + " present in the tree? " + bst.search(searchKey));

        System.out.print("Enter the element you want to remove: ");
        int removeKey = sc.nextInt();
        if (bst.search(removeKey)) { //check if the element is present or not before removal
            bst.remove(removeKey);
            System.out.println("Removed " + removeKey + " from the tree.");
        } else {
            System.out.println("Element to be removed is not present");
        }

        bst.inorderTraversal(); //check the tree after removal
    }
}

/*
OUTPUT:
Enter no. of elements you want to insert: 7
Enter the elements: 50 30 20 40 70 60 80
Preorder Traversal:
50 30 20 40 70 60 80
Inorder Traversal:
20 30 40 50 60 70 80
Postorder Traversal:
20 40 30 60 80 70 50
Levelorder Traversal:
50 30 70 20 40 60 80
Number of nodes: 7
Number of leaves: 4
Height of the tree: 2
Enter the element you want to search for: 60
Is 60 present in the tree? true
Enter the element you want to remove: 30
Removed 30 from the tree.
Inorder Traversal:
20 40 50 60 70 80
*/