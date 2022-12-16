package Random.AttendancePoints.PalindromStackAndQueue;

import java.util.EmptyStackException;

public class OurStackChar {

    int maxSize;
    int top;
    char elements[];


    public OurStackChar (int n){

        maxSize = n;
        elements = new char[maxSize];
        top = 0;

    }

    public boolean isEmpty() {
        return
                top == 0;
    }

    public void show() {
        for(char e : elements)
            System.out.println(e + " ");
    }

    public void push(char data) {

        if(top < maxSize) {
            elements[top] = data;
            top++;

        } else {

            System.out.println("Stack is full");

        }

    }

    public char pop() {
        char temp;
        top--;
        temp = elements[top];
        elements[top] = 0;
        return temp;
    }

    public char peek(){
        char temp;
        temp = elements[top - 1];
        System.out.println(temp);
        return temp;



    }


    }












