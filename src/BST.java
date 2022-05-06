public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    private boolean printLevel(Node root, int level) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
            return true;
        }

        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);

        return left || right;
    }

    public void printLevelOrder(Node root) {
        int level = 1;

        while(printLevel(root, level)){
            level++;
        }
    }
}
