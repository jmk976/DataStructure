package Sec6_Arrays;

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {

    
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

    public static void main(String[] args) {
        System.out.println("testttt");

        int[] test = {1,2,-1,3,9};
        int ans = maxSubArray(test);

      
        System.out.println("정답: "+ ans);
    
          
     }
    
}
