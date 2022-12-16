package LinkedList.Task;

import java.sql.SQLOutput;

class Node {
    Student data;
    Node prev;
    Node next;

    public Node(Student data) {
        this.data = data;
    }
}

class DoubleLinkedList {
    Node head;

    public void insertAtEnd(Student data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void insertAtStart(Student data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void printListBackwards() {
        Node current = head;
        if (head == null) {
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.println(current.data.getName() + " "+ current.data.getId() +  " " + current.data.getGpa() +  " ");
            current = current.prev;
        }
    }

    public  void deleteAllButLowestGPA(DoubleLinkedList list) {
        Node current = list.head;
        Student lowestGPA = (Student) current.data;
        while (current != null) {
            Student student = (Student) current.data;
            if (student.lessThanOrEqualTo(lowestGPA)) {
                lowestGPA = student;
            }
            current = current.next;
        }
        current = list.head;
        while (current != null) {
            if (!((Student) current.data).equals(lowestGPA)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    list.head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }


}

class Student {
    String name;
    int id;
    double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean equals(Student other) {
        return this.gpa == other.gpa;
    }

    public boolean lessThanOrEqualTo(Student other) {
        return this.gpa <= other.gpa;
    }


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Student s1 = new Student("Zeljko", 2021230319, 4.0);
        Student s2 = new Student("Dusan", 2021230333, 3.9);
        Student s3 = new Student("Marko", 2021230425, 3.2);
        list.insertAtEnd(s1);
        list.insertAtEnd(s2);
        list.insertAtEnd(s3);




        // Find student with lowest GPA
        Node current = list.head;
        Student lowestGPA = (Student) current.data;
        while (current != null) {
            Student student = (Student) current.data;
            if (student.lessThanOrEqualTo(lowestGPA)) {
               lowestGPA = student;
            }
           current = current.next;
        }
        System.out.println("Student with lowest GPA: " + lowestGPA.name + " (" + lowestGPA.gpa + ")");



        // Delete all students except the one with lowest GPA
        list.deleteAllButLowestGPA(list);
        list.printListBackwards();










    }
}











