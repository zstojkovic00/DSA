package MathForDSA;

public class PrimeNumbers {
    public static void main(String[] args) {
int n = 37;
boolean[] primes = new boolean[n+1];
sieve(primes,n);


}
// Time complexity is O(N*log(logN))
static void sieve(boolean[] primes, int n){
    for (int i = 2; i*i <=n; i++) {
        if(!primes[i]){
            for (int j = i*2; j <= n ; j+=i) {
             primes[j] = true;
            }
        }
    }
    for (int i = 2; i <= n ; i++) {
        if(!primes[i]){
            System.out.printf(i+" ");
        }
    }


}



}
