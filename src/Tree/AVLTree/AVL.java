package Tree.AVLTree;
import lombok.Getter;

/*
AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree where the difference between heights
of left and right subtrees for any node cannot be more than one.
AVL tree rotate to keep itself balanced
1 Case: Left
2 Case: Left - Right
3 Case: Right
4 Case: Right - Left
 */

public class AVL {


    public class Node {
        @Getter
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public AVL() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }


    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right) + 1);

        return rotate(node);
    }


    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // left - left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // left - right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // right - right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right - left case
                node.left = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }


    public Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }
    public boolean balancedTree() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);

    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }


    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }


    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.println(node.value);
        preOrder(node.right);
    }


    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
//        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        tree.populate(nums);

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

//        tree.display();
        System.out.println(tree.height(tree.root));

//        tree.preOrder();
    }


}
