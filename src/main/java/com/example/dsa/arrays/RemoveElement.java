package leetcode.arrays;

//LeetCode easy
public class RemoveElement {

    //time complexity O(n) and space complexity 0(1)
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=val){
                nums[count] = nums[i];
                count++;
                System.out.print(nums[count] +" ");
            }
        }
        System.out.println();
        System.out.println("Array size after removing element " +count);

        return count;


    }

    public static void main(String[] args) {
        removeElement(new int[]{3,2,3,2}, 2);

    }
}
