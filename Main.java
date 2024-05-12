public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(23);
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(11);
        tree.insert(4);
        tree.insert(7);
        
        System.out.println("Preorder traversal: ");
        tree.preOrder(tree.root);
        System.out.println("\nInorder traversal: ");
        tree.inOrder(tree.root);
        System.out.println("\nPostorder traversal: ");
        tree.postOrder(tree.root);

        System.out.println("\n\nLevel order traversal:");

        tree.printLevelOrder();
    }
}
