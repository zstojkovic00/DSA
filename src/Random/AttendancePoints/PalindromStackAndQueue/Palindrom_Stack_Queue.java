
// Napisati program Palindrom u kome se korišćenjem steka i reda za čekanje
//        proverava da li je rečenica palindrom. (Rečenica je palindrom ako se isto čita
//        sleva na desno kao i zdesna na levo, računajući samo njena slova i bez obzira
//        na to da li su velika ili mala.) Preciznije,
//        (a) Modifikovati implementacije steka i reda za čekanje sa predavanja (u faj‐
//        lovima TestStekLista.java i TestRedLista.java) tako da njihovi
//        elementi budu znakovi tipa char, a ne celi brojevi tipa int.
//        (b) U metodu main() učitati rečenicu i samo njena slova (sva pretvorena,
//        recimo, u mala slova) redom dodavati istovremeno u jedan stek i u jedan
//        red. Zatim naizmeničnim uklanjanjem tih slova iz steka i reda odrediti da
//        li je ulazna rečenica palindrom i prikazati odgovarajuću poruku.





package Random.AttendancePoints.PalindromStackAndQueue;
import java.util.Scanner;
import java.io.*;

public class Palindrom_Stack_Queue {
    public static void main(String[] args) throws IOException {

          OurStackChar stack = new OurStackChar(20);
          OurQueueChar queue = new OurQueueChar(20);

        System.out.print("Enter any string:");
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();

//          stack.push('A');
//          stack.push('B');
//          stack.push('C');
//          stack.push('D');
//          stack.push('E');
//          stack.pop();
//          stack.pop();
//          stack.show();
//          stack.peek();



        for (int i = 0; i < inputString.length() ; i++) {
            stack.push(Character.toLowerCase(inputString.charAt(i)));
            queue.enQueue(Character.toLowerCase(inputString.charAt(i)));

        }



         String reverseString = "";
        String reverseString2 = "";


       while (!stack.isEmpty()) {
          reverseString = reverseString+stack.pop();
       }

        if (inputString.equals(reverseString))
            System.out.println("Stack : The input String is a palindrome.");
        else
           System.out.println("The input String is not a palindrome.");


        while (!queue.isEmpty()) {
            reverseString2 = reverseString2+queue.remove();
        }
        if (inputString.equals(reverseString2.toString()))
            System.out.println("Queue : The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }






    }




