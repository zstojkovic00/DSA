package Recursion;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(fiboGolden(61));
    }

    static long fiboGolden(long n){

        return (long) (Math.pow(((1+Math.sqrt(5)) / 2 ),n)  / Math.sqrt(5));
    }



    static int fibo(int n){
        if(n<2){
            return n;
        }

        return fibo(n-1)+fibo(n-2);
    }
}
