package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDig(1234));

    }


    static int sumOfDig(int n){
        if(n == 0){
            return 0;
        }

        return (n%10) + sumOfDig(n/10);
    }
}
