class BSTreeNode{
    int data;
    BSTreeNode left, right;

    public BSTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void addChild(int data) {
        if (data == this.data) {
            return;
        }
        if (data < this.data) {
            if (this.left != null) {
                this.left.addChild(data);
            } else {
                this.left = new BSTreeNode(data);
            }
        }
        else {
            if (this.right != null) {
                this.right.addChild(data);
            } else {
                this.right = new BSTreeNode(data);
            }
        }
    }

    public void leafNodes() {
        if (this.left == null && this.right == null) {
            System.out.print(this.data + " ");
        }
        if (this.left != null) {
            this.left.leafNodes();
        }
        if (this.right != null) {
            this.right.leafNodes();
        }
    }

    public int findMax() {
        if (this.right != null) {
            return this.right.findMax();
        } else {
            return this.data;
        }
    }

    public int findMin() {
        if (this.left != null) {
            return this.left.findMin();
        } else {
            return this.data;
        }
    }

    public BSTreeNode delete(int val) {
        if (val < this.data) {
            if (this.left != null) {
                this.left = this.left.delete(val);
            }
        }
        else if (val > this.data) {
            if (this.right != null) {
                this.right = this.right.delete(val);
            }
        }
        else {
            if (this.left == null && this.right == null) {
                return null;
            }
            if (this.left == null) {
                return this.right;
            }
            if (this.right == null) {
                return this.right;
            }
            int min = this.right.findMin();
            this.data = min;
            this.right = this.right.delete(min);
        }
        return this;
    }

    public boolean search(int val) {
        if (this.data == val) {
            return true;
        }
        if (val < this.data) {
            if (this.left != null) {
                return this.left.search(val);
            } else {
                return false;
            }
        }
        if (val > this.data) {
            if (this.right != null) {
                return this.right.search(val);
            } else {
                return false;
            }
        }
        return false;
    }

    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.print(this.data + "--> ");
        if (this.right != null) {
            this.right.inorder();
        }
    }

    public void postorder() {
        if (this.left != null) {
            this.left.postorder();
        }
        if (this.right != null) {
            this.right.postorder();
        }
        System.out.print(this.data + "--> ");
    }

    public void preorder() {
        System.out.print(this.data + "--> ");
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }
}

public class BST {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 9, 17, 18, 20, 23, 34};
        BSTreeNode numbersTree = buildBST(numbers);
        numbersTree.delete(9);
        numbersTree.postorder();
        System.out.println();
        numbersTree.leafNodes();
    }

    static BSTreeNode buildBST(int[] elements) {
        BSTreeNode root = new BSTreeNode(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            root.addChild(elements[i]);
        }
        return root;
    }
}
