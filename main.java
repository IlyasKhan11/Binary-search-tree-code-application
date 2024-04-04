import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    static Scanner scanner = new Scanner(System.in);

    public static Node insertData(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data <= root.data) {
            root.left = insertData(root.left, data);
        } else {
            root.right = insertData(root.right, data);
        }
        return root;
    }

    public static Node takeInput() {
        Node root = null;
        System.out.println("Enter data (or -1 to stop): ");
        while (true) {
            int data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            root = insertData(root, data);
        }
        return root;
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = takeInput();
        System.out.print("Level Order Traversal: ");
        levelOrderTraversal(root);
    }
}
