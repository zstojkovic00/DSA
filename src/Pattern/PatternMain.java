package Pattern;

public class PatternMain {
    public static void main(String[] args) {
        // pattern1(4);
        pattern30(4);

    }


    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern3(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }


    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();

        }

    }


    static void pattern5(int n) {
        for (int i = 0; i < 2*n-i; i++) {
            int col = 0;
            for (int j = 0; j < col; j++) {
                System.out.println("*");
            }
            System.out.println();
        }



    }


    static void pattern30(int n){
        for (int i = 0; i <= n ; i++) {

            for (int s = 0; s < n-i ; s++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1 ; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i ; j++) {
                System.out.print(j);
            }
            System.out.println();

        }


    }


    static void pattern28(int n){
        for (int i = 0; i < 2*n; i++) {
            int totalColInRow = i > n ? 2 * n - i : i;

            int noOfSpaces = n - totalColInRow;
            for(int s = 0; s < noOfSpaces; s++){
                System.out.print(" ");
            }

            for (int j = 0; j < totalColInRow; j++) {
                System.out.print(" *");
            }
            System.out.println();


        }
    }



}
