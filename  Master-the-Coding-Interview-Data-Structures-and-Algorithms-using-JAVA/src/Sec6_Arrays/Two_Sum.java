package Sec6_Arrays;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        
        //return 
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(i, nums[i]);
        }

        for(int i =0;i< nums.length-1; i++){
           int add1 = map.get(i);
           int add2 = target - add1;

        }

        //n개면 (n-1)n를 계수로.. 돌리면.. 4 3*2  3번  3+2+1
        
        
        return
    }
    
}
