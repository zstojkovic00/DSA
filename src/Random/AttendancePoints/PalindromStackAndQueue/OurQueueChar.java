package Random.AttendancePoints.PalindromStackAndQueue;

public class OurQueueChar {
    int maxSize;
    char  elements [];
    int front;
    int rear;
    int nItems;


    public OurQueueChar (int n) {
        maxSize = n;
        elements = new char[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;

    }

    public void enQueue(char data){
        if(rear == maxSize - 1)
            rear = -1;

        elements[++rear] = data; // fist inc than add data
        nItems++;

    }

    public boolean isEmpty(){

        return nItems == 0;
    }

    public char deQueue (){

        char temp = elements[front++]; //First take data and than inc

        if(front == maxSize)
            front = 0;

        nItems--;
        return temp;
    }

    public char remove (){

        char temp = elements[rear--];

        if(front == maxSize)
            front = 0;

        nItems--;
        return temp;
    }


}
