package Sec6_Arrays;

import java.util.Arrays;

public class Rotate_Array {
    public static int[] rotate(int[] nums, int k) { 
        //self-solution

        int[] afterArray = new int[nums.length];
        //이동할 위치
        int spot = k%nums.length;

        for(int i = 0; i < nums.length; i++){

            if( i+spot > nums.length-1 ){
               int spot2 =  i+spot-nums.length;
              afterArray[spot2] =  nums[i]; 
            } else if( i+spot < nums.length ){
                afterArray[i+spot] = nums[i];
            } 
          
        }

        for (int h = 0; h < nums.length; h++) {
            nums[h] =  afterArray[h];
            }

        return nums;
    }

    public static int[] rotate2(int[] nums, int k) {
        //1번을 완전 단순화 한것
        //Approach 2: Using Extra Array
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
          a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
          nums[i] = a[i];
        }
        return nums;
      }

    public static void main(String[] args) {
        System.out.println("testttt");

        int[] test ={1,2,3,4,5,6,7};
        int ro = 3;
        int[] ans = rotate2(test, ro);

      
        System.out.println("정답: "+ Arrays.toString(ans));

    
          
     }
    
}
