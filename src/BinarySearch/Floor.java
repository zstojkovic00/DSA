package BinarySearch;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 10;

        int ans = floor(arr,target);
        System.out.println(ans);
    }

    static int floor(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        // find whether the array is sorted in ascending or descending
      boolean isAsc  = arr[start] < arr[end];

        if(target < start){
            return -1;
        }
        while(start <= end){
            //int mid = (start+end) / 2;
            // might be possible that start + end exceeds the range of integer size
            int mid = start + (end - start) / 2;


            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
                if(target < arr[mid]){
                    end = mid -1;
                } else{
                    start = mid + 1;
                }
            } else {
                    if(target > arr[mid]){
                        end = mid -1;
                    } else{
                        start = mid + 1;
                    }

            }

        }
        return end;


    }
}
