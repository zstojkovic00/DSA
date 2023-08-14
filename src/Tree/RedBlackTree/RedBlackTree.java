package Tree.RedBlackTree;

import lombok.Data;

/*
Red-Black Tree is a self-balancing binary search tree. It was introduced by Rudolf Bayer and Volker Strassen.
While Red-Black Trees share similarities with AVL Trees in their self-balancing.
Red-Black Trees trade-off between perfect balance and number of rotations

It has the same properties like a binary search tree plus a few more:
    1) Node color: red or black
    2) Root property: The root is always black
    3) External property: Every external node is black
    4) Red property: Children of red node must be black
    5) Black depth property: The number of black nodes from the root to any NULL node in any path must be the same
 */
public class RedBlackTree {


    @Data
    public class Node {
        private int value;
        private int color;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value, int color) {
            this.value = value;
            this.color = color;
        }
    }

    private Node root;
    private static final int BLACK = 0;
    private static final int RED = 1;

    public RedBlackTree(){

    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value + " (Color: " + (node.color == BLACK ? "Black" : "Red") + ")");

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    private void insert(int value){
        Node newNode = new Node(value,RED);
        root = insert(root, newNode);
        fixInsertion(newNode);
    }

    private Node insert(Node root, Node newNode){
        if(root == null){
            return newNode;
        }
        if (newNode.value < root.value) {
            root.left = insert(root.left, newNode);
            root.left.parent = root;
        }
        else if (newNode.value > root.value) {
            root.right = insert(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }


    private void fixInsertion(Node node) {
        while (node.parent != null && node.parent.color == RED) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        node = parent;
                        leftRotate(node);
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rightRotate(grandparent);
                }
            } else {
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rightRotate(node);
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    leftRotate(grandparent);
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rightRotate(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(12);
        tree.insert(18);

        tree.display();
    }



}
