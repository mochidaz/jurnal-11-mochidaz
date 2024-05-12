import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    int depth;

    BinaryTree() {
        root = null;
    }

    void insert(int data) {
        depth = getDepth(root, 0);
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (height(root.left) <= height(root.right)) {
                root.left = insertRec(root.left, data);
            } else {
                root.right = insertRec(root.right, data);
            }
        }
        return root;
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int getDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }

        return getDepth(root.left, depth + 1);
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void printTree() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node current = queue.poll();
                System.out.print(current.data);

                if (current.left != null || current.right != null) {
                    System.out.print("<");
                }

                if (current.left != null) {
                    queue.add(current.left);
                    System.out.print(current.left.data);
                }

                System.out.print(" ");

                if (current.right != null) {
                    System.out.print(current.right.data);
                    queue.add(current.right);
                }

                if (current.left != null || current.right != null) {
                    System.out.print(">");
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void printLevelOrder() {
        if (root == null) {
            return;
        }
    
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            while (size-- > 0) {
                Node current = queue.poll();
                System.out.print(" ".repeat(count++) + current.data + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }
}