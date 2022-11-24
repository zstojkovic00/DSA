package Recursion;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,55,66,78};
        int target = 66;
        System.out.println(RecursiveBS(arr,target,0,arr.length-1));

    }

    static int RecursiveBS(int[] arr, int target, int s, int e){

        if(s > e){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m] == target){
            return m;
        }
        if(target < arr[m]){
            RecursiveBS(arr,target,s, m -1);
        }
        return RecursiveBS(arr,target,m+1,e);


    }
}
