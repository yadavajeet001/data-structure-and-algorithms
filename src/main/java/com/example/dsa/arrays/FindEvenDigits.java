package leetcode.arrays;

public class FindEvenDigits {
    public static void main(String[] args) {
        int[] arr = {12, 23, 4 , 234, 4533, 4};
        int res = findEvenDigit(arr);
        System.out.println(res);
        System.out.println(digits2());
    }

    private static int findEvenDigit(int[] arr) {
        int count = 0;
        for (int num : arr){
          if (even(num)){
              count++;
          }
        }
        return count;
    }

    private static boolean even(int num) {
        int numOfDigits = digits(num);
        return numOfDigits % 2 == 0;
    }

    private static int digits(int num) {
        int count =0;
        while (num>0){
            count++;
            num = num/10;
        }
        return count;
    }

    //find the number of digit in optimized way
    private static int digits2() {
        return (int) (Math.log10(35353) + 1);
    }

}
