package Tree.BTree;


/*
B-Tree is a special type of self-balancing search tree in which each node can contain more than one
key and can have more than two children. It is also known as a height-balanced m-way tree
B-tree are widely used in databases to index and store data efficiently.
 */


public class BTree {

    private int M;
    private Node root;
    private int height;

    public BTree() {
        this(4);
    }

    public BTree(int M) {
        this.M = M;
        this.root = new Node(0);
    }

    private class Node {
        private int m;
        private Entry[] children = new Entry[M]; // Array to hold key-value pairs and child nodes

        private Node(int m) {
            this.m = m;
        }
    }

    private class Entry {
        private Integer key, value;
        private Node next;

        private Entry(Integer key, Integer value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    // Search for a key in the B-Tree
    public Integer search(Integer key) {
        return search(root, key, height);
    }

    private Integer search(Node node, Integer key, Integer level) {
        if (level == 0) {
            // If we have reached the leaf level, iterate through keys
            // Return if found
            for (int i = 0; i < node.m; i++) {
                if (key.compareTo(node.children[i].key) == 0) {
                    return node.children[i].value;
                }
            }
        } else {
            // If we haven't reached the leaf level, traverse child nodes based on key values
            // If the key is less than the current key or the next key, move to the corresponding child node
            for (int i = 0; i < node.m; i++) {
                if (i + 1 == node.m || key.compareTo(node.children[i + 1].key) < 0) {
                    return search(node.children[i].next, key, level - 1);
                }
            }
        }
        return null;
    }

    // Insert a key-value in B-Tree
    public void insert(Integer key, Integer value) {
        Node newNode = insert(root, key, value, height);
        if (newNode == null) {
            return;
        }


        // If insertion caused root to split, create new root with two children
        Node newRoot = new Node(2);
        newRoot.children[0] = new Entry(root.children[0].key, null, root);
        newRoot.children[1] = new Entry(newNode.children[0].key, null, newNode);
        root = newRoot;
        height++;
    }

    private Node insert(Node node, Integer key, Integer value, Integer level) {
        Entry newEntry = new Entry(key, value, null);
        int position;

        if (level == 0) {
            // If we have reached the leaf level, find the correct position and insert the new entry
            for (position = 0; position < node.m; position++) {
                if (key.compareTo(node.children[position].key) < 0) {
                    break;
                }
            }
        } else {
            // if we haven't reached the left level yet, traverse child nodes
            // Insert and if the insertion causes the node to split,
            //  update the new entry's key and next references, and handle node splitting.
            for (position = 0; position < node.m; position++) {
                if (position + 1 == node.m || key.compareTo(node.children[position + 1].key) < 0) {
                    Node newNode = insert(node.children[position++].next, key, value, level - 1);
                    if (newNode == null) {
                        return null;
                    }
                    newEntry.key = newNode.children[0].key;
                    newEntry.next = newNode;
                    break;
                }
            }
        }
        // Shift existing entries to make space for the new entry and insert it.
        for (int j = node.m; j > position; j--) {
            node.children[j] = node.children[j - 1];
        }
        node.children[position] = newEntry;
        node.m++;

        // If node's size exceeds the maximum allowed, split the node
        if (node.m < M) {
            return null;
        }

        return split(node);
    }

    // Split a node when it becomes full
    private Node split(Node node) {
        Node newNode = new Node(M / 2);
        node.m = M / 2;

        for (int i = 0; i < M / 2; i++) {
            newNode.children[i] = node.children[i + M / 2];
        }

        return newNode;
    }

    public static void main(String[] args) {
        BTree tree = new BTree();
        for (int i = 0; i < 100; i++) {
            tree.insert(i, i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(tree.search(i));
        }
    }
}


