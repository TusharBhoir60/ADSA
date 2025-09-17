import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    // Search a given key in BST
    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key > root.key)
            return search(root.right, key);

        return search(root.left, key);
    }

    // Utility function
    void searchKey(int key) {
        Node result = search(root, key);
        if (result != null)
            System.out.println("Key " + key + " found in BST.");
        else
            System.out.println("Key " + key + " not found in BST.");
    }

    // Insert function (to build BST)
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    // Utility method to insert key into tree starting from root
    void insertKey(int key) {
        root = insert(root, key);
    }
}

public class keyBST {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);

        // Get number of values to insert in BST
        System.out.print("Enter number of values to insert in BST: ");
        int n = sc.nextInt();

        // Get values from user and insert into BST
        System.out.println("Enter " + n + " integer values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tree.insertKey(value);
        }

        // Search keys
        System.out.print("Enter key to search: ");
        int searchKey = sc.nextInt();
        tree.searchKey(searchKey);

        sc.close();
    }
}