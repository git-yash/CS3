public class TreeRunner {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(23);
        int[] nums = {11, 45, 7, 17, 27, 67, 9};

        for (int num : nums) {
            tree.root.insert(num);
        }

        System.out.println("In order: ");
        tree.root.printInOrder();
        System.out.println("\n");

        System.out.println("Level order: ");
        tree.printLevelOrder(tree.root);
        System.out.println("\n");

        System.out.println("Post order: ");
        tree.printPostOrder(tree.root);
        System.out.println("\n");

        System.out.println("Pre order: ");
        tree.printPreOrder(tree.root);
        System.out.println("\n");
    }
}
