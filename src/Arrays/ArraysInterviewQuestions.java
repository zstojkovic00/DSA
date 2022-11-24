package Arrays;
import java.util.Arrays;

public class ArraysInterviewQuestions {

    public static void main(String[] args) {
        ArraysInterviewQuestions arrQ = new ArraysInterviewQuestions();

        int nums[] = {5,10,20,30,40,40,50};
        int nums2[] = {50,40,40,30,20,10,5,0};
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};

        int[] result = arrQ.twoSum(nums, 80);
        System.out.println(Arrays.toString(result));
        arrQ.linearSearch(nums, 5);
        String pairs = arrQ.maxProduct(nums);
        System.out.println(pairs);
        boolean result2 = arrQ.isUnique(nums);
       // System.out.println(result2);
        boolean result3 = arrQ.permutation(nums,nums2);
        System.out.println(result3);
        arrQ.rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    // Question 1, Write a program to find all pairs of integer whose sum si equal to a given number

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{-1, -1};
    }


    // Question 2, Write a program to check if an array contains a number in Java

    public void linearSearch(int nums[], int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }
        System.out.println(value+" is not found");
    }
    
    
    // Question 3, Write a program to find maximum product of two integers in the array where all elements are positive
    
    public String maxProduct(int nums[]){
        int maxProduct = 0;
        String pairs = "";
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]*nums[j]>maxProduct){
                    maxProduct = nums[i]*nums[j];
                    pairs = Integer.toString(nums[i]) + "," + Integer.toString(nums[j]);
                }
            }
        }
        return pairs;

    }

    // Question 4, Write a program to check if an array is unique or not

    public boolean isUnique(int nums[]){
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] == nums[j])
                    return false;
            }
        }
        return true;
    }

    // Question 5, Permutation, You are given two integer arrays. Write a program to check if they are permutation of each other

     public boolean permutation(int nums[], int nums2[]){
        if(nums.length != nums2.length){
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;
         for (int i = 0; i < nums.length ; i++) {
             sum1+= nums[i];
             sum2 = nums2[i];
             mul1 *= nums[i];
             mul2 *= nums2[i];
         }
         if( sum1 == sum2 && mul1 == mul2)
             return true;
         return false;


     }

     // Question 6 , Rotate Matrix , Given an integer by an NxN matrix write a method to rotate the image by 90 degrees

     public boolean rotateMatrix(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length )
            return false;
        int n = matrix.length;
         for (int layer = 0; layer < n/2; layer++) {
             int first = layer;
             int last = n - 1 - layer;
             for(int i= first;i<last; i++){
                 int offset = i - first;
                 int top = matrix[first][i];

                 matrix[first][i] = matrix[last-offset][first];
                 matrix[last-offset][first]= matrix[last][last-offset];
                 matrix[last][last-offset] = matrix[i][last];
                 matrix[i][last] = top;

             }
         }
         return true;
     }


}
