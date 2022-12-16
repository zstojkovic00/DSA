//. Napisati Java program BinarnaPretraga kojim se realizuje binarna pretraga
//sortiranog niza na rekurzivan način. Preciznije, glavna klasa programa treba
//da sadrži bar sledeća dva metoda:
//(a) Rekurzivni metod binPretraga(a,x,i,j) koji kao rezultat vraća po‐
//ziciju elementa celobrojnog sortiranog niza a jednakog vrednosti x, pri
//čemu se oblast pretrage niza a sastoji od njegovog 𝑖‐tog do njegovog 𝑗‐
//tog elementa. U slučaju da se vrednost x ne nalazi u toj oblast pretrage,
//rezultat metoda binPretraga(a,x,i,j) treba da bude −1.
//(b) Metod main() u kome se najpre generiše celobrojni niz a od 50 eleme‐
//nata sa slučajnim vrednostima iz opsega od 1 do 100, zatim se generi‐
//sani niz sortira metodom Arrays.sort() iz paketa java.util, pa se
//generiše slučajna vrednost x iz opsega od 1 do 100 i, na kraju, prikazuje
//se sortiran niz a i pozicija vrednosti x u tom nizu (ili −1 ako se ona tu ne
//nalazi) pozivom prethodnog rekurzivnog metoda binPretraga()

package Random.AttendancePoints;
import java.util.Arrays;


public class RecursiveBinarySearch {


    public static void main(String[] args) {
        int n = 50;
        int arr[] = new int[n];

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = (int)(100*Math.random());
        }

        Arrays.sort(arr);
        int x = (int)(100*Math.random());



        System.out.println(Arrays.toString(arr));
        System.out.println("Value of x: "+x);

        System.out.println("His position in the array is: "+RecursiveBS( arr,0,arr.length-1,x));


    }


    static int RecursiveBS(int[] arr, int s, int e, int x){
        if (e >= s){
            int mid = s + (e - s) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return RecursiveBS(arr, s, mid - 1, x);
            return RecursiveBS(arr, mid + 1, e, x);
        }
        return -1;
    }


    }

