package LinkedList;

public class MainCLL {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(10);
        list.insert(3);
        list.insert(2);
        list.insert(8);
        list.insert(75);
        list.display();
        list.delete(2);
        list.display();

    }
}
