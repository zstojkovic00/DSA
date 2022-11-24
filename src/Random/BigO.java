package Random;

import java.util.Arrays;


public class BigO {
    public static void main(String[] args) {
        BigO bigO = new BigO();
        int[] customNums = {1,2,3,4,5};
        bigO.sumAndProduct(customNums);
        bigO.pairsOfArray(customNums);
        bigO.reverseArray(customNums);
    }


    // Question 1 , Create a function which calculates the sum and produc of elements of array,
    // Find the time complexity for created method.


    public void sumAndProduct(int[] nums) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            product *= nums[i];
        }
        System.out.println(sum);
        System.out.println(product);
    }

    // Time complexity is O(n)

    // Question 2, Program to print the duplicate elements of an array
    // Find the time complexity for created method.


    public void pairsOfArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println(nums[j]);
                }
            }
        }

    }
    // Time complexity is O(n^2)


    // Question 3, Create a method which takes an array as a paramterer and reverse it,
    // Find the runtime of the created method.

    public void reverseArray(int[] nums){
        for (int i = 0; i < nums.length/2 ; i++) {
           int temp = nums[i];
           nums[i] = nums[nums.length-i-1];
           nums[nums.length-i-1] = temp;

        }
        System.out.println(Arrays.toString(nums));
    }


    // Time complexity is 0(n)



}
