package Tree.SegmentTree;

/*
Segment Tree also known as a statistic tree is a tree used for storing information about intervals, or segments
it allows querying which of the stored segments contain a given point.
1 Case: Node is completely lying inside query
2 Case: Completely outside
3 Case: Overlapping
 */


public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        //create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);


        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int queryStartIndex, int queryEndIndex) {
        return this.query(this.root, queryStartIndex, queryEndIndex);
    }

    private int query(Node node, int queryStartIndex, int queryEndIndex) {
        if (node == null) {
            return 0; // Return 0 for null nodes
        }

        if (node.startInterval >= queryStartIndex && node.endInterval <= queryEndIndex) {
            // node is completely lying inside query
            return node.data;
        } else if (node.startInterval > queryEndIndex || node.endInterval < queryStartIndex) {
            // completely outside
            return 0;
        } else {
            // overlapping
            return this.query(node.left, queryStartIndex, queryEndIndex) + this.query(node.right, queryStartIndex, queryEndIndex);
        }
    }


    private int update(Node node, int index, int value) {
        // check if index lies in interval
        if (index >= node.startInterval && index <= node.endInterval) {
            // update
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            // otherwise return left and right and
            else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
         tree.display();

        System.out.println(tree.query(0, 7));
    }
}
