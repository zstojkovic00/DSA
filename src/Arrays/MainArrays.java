package Arrays;

import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        // System.out.println(Arrays.toString(arr));

        String stringArr[] = {"a","b","c"};
       // System.out.println(Arrays.toString(stringArr));


        //Insertion in Array

        SingleDimensionsArrays sda = new SingleDimensionsArrays(3);
        sda.insert(0,10);
        sda.insert(1,20);
        sda.insert(2,30);

        var firstElement = sda.arr[0];
        System.out.println(firstElement);



        // Traversal Array
        System.out.println("Array traversal");

        sda.traverseArray();

        //Search in Array

        sda.searchInArray(20);
        sda.searchInArray(100);











    }
}
