package Random;

class Recrusion {
    public static void main(String[] args){
        Recrusion recrusion = new Recrusion();
        var rec1 = recrusion.factorial(6);
        var rec2 = recrusion.fibonacci(7);
        var rec3 = recrusion.sumOfDigits(3);
        var rec4 = recrusion.powerOfDigits(20,-10);
        var rec5 = recrusion.gcd(100, 30);
        var rec6 = recrusion.decimalToBinary(-13);
        System.out.println(rec1);
        System.out.println(rec2);
        System.out.println(rec3);
        System.out.println(rec4);
        System.out.println(rec5);
        System.out.println(rec6);

    }

    // Factorial of random number
    public int factorial(int n){
        if(n<1){
            return -1;
        }
        if(n==0 || n == 1 ){
            return n;
        }
        return n* factorial(n-1);
    }
    // Fibonacci sequence;
    public int fibonacci(int n){
        if(n<0){
            return -1;
        }
        if(n==0 || n == 1 ){
            return 1;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    // Interview Questions (Recrusion)

    // Question number 1, How to find the sum of digits of a positive integer number using recrusion?

    public int sumOfDigits(int n){
        if(n<0){
            return 0;
        }
        if(n == 0){
            return 0;
        }

        return n % 10 + sumOfDigits(n/10);

    }

    // Question number 2 , How to calculate power of a number using recrusion?

    public double powerOfDigits(int base,int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / powerOfDigits(base, -exponent);
        }
        else {
            double results = base * powerOfDigits(base, exponent - 1);
            return results;
        }
    }

    // Question number 3, How to find GCD(Greates Common Divisor) of two numbers using recrusion?

    public int gcd(int x , int n){
        //Euclidean algorithm
        if( n == 0){
            return x;
        }
        if(n<0 || x < 0){
            return -1;
        }

        return gcd(n, x%n);
    }

    // Question number 4, How to convert a number from Decimal to Binary using recrusion?
    public int decimalToBinary(int n){
        if(n == 0){
            return 0;
        }

        return n%2  + 10*decimalToBinary(n/2);
    }


}
