package BinaryTree;

public class BST {

    public Node root;

    public BST(){
        this.root = null;
    }

   public boolean find(int id ){
        Node current = root;

        while(current != null){
            if(current.data == id){
                return true;
            }else if(current.data > id){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return false;
   }

   public void insert(int id){
        Node newNode = new Node(id);
        if(root == null){
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;


        while(true){
            parent = current;

            if(id < current.data){
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
            } else {
                    current = current.right;
                    if(current ==null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

   }


}
