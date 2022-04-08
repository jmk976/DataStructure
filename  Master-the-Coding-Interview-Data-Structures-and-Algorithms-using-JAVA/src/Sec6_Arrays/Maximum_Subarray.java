package Sec6_Arrays;

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        //Time: O(N^2)
        //Space: O(1)
        //Time Limit Error 
        // 1st try :Brute Force

    
        int output = nums[0];

        for(int i = 0; i < nums.length; i++){
           
            int preSum = 0;
            preSum = nums[i];
            if(output <= preSum){
                output = preSum;
            }

            for(int j = i+1; j < nums.length; j++){
             
                preSum += nums[j];
                if(output < preSum){
                    output = preSum;
                }
                
            }
        }
        System.out.println(output);
        return output;
        
    }

    public static int maxSubArray2(int[] nums) {
        //Time: O(n)
        //Space: O(1)
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];

            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("testttt");

        int[] test = {1,2,-1,3,9};
        int ans = maxSubArray2(test);

      
        System.out.println("정답: "+ ans);
    
          
     }
    
}
