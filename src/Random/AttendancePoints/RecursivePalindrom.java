//Napisati Java program Palindrom2 kojim se proverava da li je neka rečenica
//        palindrom. (Rečenica je palindrom ako se isto čita sleva na desno i zdesna na
//        levo, računajući samo njena slova i bez obzira na to da li su velika ili mala.)
//        Preciznije, program treba da sadrži bar sledeća dva metoda:
//        (a) Rekurzivni metod obrniString(s) čiji je rezultat string koji se sasto‐
//        ji od znakova datog stringa s u obrnutom redosledu. Na primer, re‐
//        zultat poziva obrniString("ab123") treba da bude string "321ba".
//        (Savet: Za rekurzivno rešenje ovog metoda može se iskoristiti metod
//        substring() iz klase String.)
//        (b) Metod main() u kome se učitava neka rečenica, zatim se proverava da li
//        je ona palindrom primenom prethodnog metoda obrniString() i, na
//        kraju, prikazuje se odgovarajuća poruka na ekranu

package Random.AttendancePoints;
import java.util.Scanner;

public class RecursivePalindrom {

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a word to check if its a palindrome or not: ");
        String word = sc.nextLine();
        if(recusivePal(word))
            System.out.println(word + " is a palindrome");
        else
            System.out.println(word + " is not a palindrome");
    }


    public static boolean recusivePal(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            // if length = 0 or 1 then it is
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            // check for first and last char of String:
            // if they are same then do the same thing for a substring
            // until you string completes or condition fails
            return recusivePal(s.substring(1, s.length()-1));

        return false;
    }
}
