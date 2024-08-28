class TNode {
    int data;
    TNode left,right;

    public TNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    TNode root;

    BinaryTree() {
        root = null;
    }

    void inorder(TNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + "-->");
            inorder(root.right);
        }
    }

    void postorder(TNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + "-->");
        }
    }

    void preorder(TNode root) {
        if (root != null) {
            System.out.print(root.data + "-->");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TNode(1);
        tree.root.left = new TNode(2);
        tree.root.right = new TNode(3);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(5);
        tree.root.right.left = new TNode(6);
        tree.root.right.right = new TNode(7);

        System.out.println("Inorder Traversal");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal");
        tree.postorder(tree.root);
    }
}
