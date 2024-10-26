package linearsearch;

public class LinearSearchInRange {
    public static void main(String[] args) {
        int[] arr ={19, 18, 3, 5, 6, 2};
        int target = 2;
        int result = linearSearchInRange(arr, target, 0, 3);
        System.out.println(result);
    }
    //return index
    public static int linearSearchInRange(int[] arr, int target, int start, int end){

        //check empty array
        if (arr.length==0) {
            return -1;
        }

        //return index of array if target element is found
        for(int index=start; index<= end; index++){

            int element = arr[index];
            if (element==target)
                return index;

        }
        //if target is not found in array return -1
        return -1;
    }
}
