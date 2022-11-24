package LinkedList;

public class MainDLL extends DLL{
    public static void main(String[] args) {
        MainDLL list = new MainDLL();



        list.insertFirst(10);
        list.insertFirst(5);
        list.insertFirst(8);
        list.insertLast(99);
        list.insert(8,65);

        list.display();
    }
}
