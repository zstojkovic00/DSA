//    Napisati program TestSearch2 za poređenje brzine dva algoritma pretrage
//    sortiranog niza. Preciznije, program treba da sadrži bar ove metode:
//            (a) Metod seqSearch(a,x), kojim se sekvencijalno pretražuje celobrojni
//    niz 𝑎 da bi se odredilo da li se broj 𝑥 nalazi u njemu. (Iskoristite algoritam
//    seq‐search sa predavanja.)
//            (b) Metod binSearch(a,x), kojim se binarno pretražuje sortiran celobroj‐
//    ni niz 𝑎 da bi se odredilo da li se broj 𝑥 nalazi u njemu. (Iskoristite algo‐
//    ritam bin‐search sa predavanja.)
//            (c) Metod main(), u kome se generiše veliki celobrojni niz od 100000 ele‐
//    menata na slučajan način i zatim se taj niz sortira bilo kojim metodom za
//    sortiranje da bi se dobio sortiran slučajni niz 𝑎. Zatim se generiše i jedan
//    slučajni broj 𝑥, a na kraju se taj broj 𝑥 traži u sortiranom slučajnom nizu
//    𝑎 primenom oba prethodna metoda i prikazuje pojedinačno vreme koje
//    je utrošeno za njihovo izvršavanje


package Random.AttendancePoints;
import java.util.Arrays;
import java.util.Random;


public class TestSearch {


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }


        }


        return -1;

    }

    static int binearySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;


        while(start <= end){
            //int mid = (start+end) / 2;
            // might be possible that start + end exceeds the range of integer size
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid -1;
            } else if(target > arr[mid]){
                start = mid + 1;
            }
            else {
                // ans found
                return mid;
            }
        }
        return -1;


    }

    static void bubble(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // for each step, max item will come at the least respective index
            for (int j = 1; j <arr.length-i ; j++) {
                // swap if the item is smaller than the previous item
                if(arr[j] < arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is soreted hence stop the program
            if(!swapped){
                break;
            }
        }
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int N = 100000;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array

        }
 int randomNumber = getRandom(arr);

        bubble(arr);
        System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        System.out.println(linearSearch(arr,randomNumber));
        System.out.println("Average Time LS: "+(System.nanoTime()-startTime)/(float)N +"ns");

        long startTime2 = System.nanoTime();
        System.out.println(binearySearch(arr,randomNumber));
        System.out.println("Average Time BS: "+(System.nanoTime()-startTime2)/(float)N +"ns");


    }
}
