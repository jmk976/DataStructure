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

    public static void rotate0(int[] nums, int k) {
      // speed up the rotation
      //Time complexity: O(n* k) All the numbers are shifted by one step(O(n)) k times.
      //Space complexity: O(1) No extra space is used.
      k %= nums.length;
      int temp, previous;
      for (int i = 0; i < k; i++) {
        previous = nums[nums.length - 1];
        for (int j = 0; j < nums.length; j++) {
          temp = nums[j];
          nums[j] = previous;
          previous = temp;
        }
      }
    }

    public static int[] rotate2(int[] nums, int k) {
        //1번을 완전 단순화 한것
        //Approach 2: Using Extra Array
        //Time complexity: O(n)
        //Space complexity: O(n)
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
          a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
          nums[i] = a[i];
        }
        return nums;
      }


      public static int[] rotate3(int[] nums, int k) {
        //Approach 3: Using Cyclic Replacements
        //Time complexity:O(n). Only one pass is used.
        //Space complexity:O(1). Constant extra space is used.
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
          int current = start;
          int prev = nums[start];
          do {
            int next = (current + k) % nums.length;
            int temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;
          } while (start != current);
        }

        return nums;
      }


      public static void rotate4(int[] nums, int k) {
        ///Approach 4: Using Reverse
        //Time complexity: O(n). nn elements are reversed a total of three times.
        //Space complexity: O(1). No extra space is used.
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
      }
      public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
      }

    public static void main(String[] args) {
        System.out.println("testttt");

        int[] test ={1,2,3,4,5,6};
        int ro = 4;
        int[] ans = rotate3(test, ro);

      
        System.out.println("정답: "+ Arrays.toString(ans));

    
          
     }
    
}
