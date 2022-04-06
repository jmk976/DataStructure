package Sec6_Arrays;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) { // time complexity O(n^2), space complexity O(1)
        
        //return 
        int[] result = new int[2];

 
        for(int i = 0; i < nums.length; i++){
           
            for(int j = i; j <nums.length; j++){
               if( nums[i] + nums[j] == target){
                   result[0] = i;
                   result[1] = j;

               }
               
            }
          
        }

        return result;
        
    }

    public static int[] twoSum2(int[] nums, int target) { // Time complexity O(n), space complexity O(n)

        int[] result = new int[2];
    

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                result[0] = i;
                result[1] = map.get(complement);

            }

        }
        return result;
    }

    public static int[] twoSum3(int[] nums, int target) { // Time complexity O(n), space complexity O(n)

        int[] result = new int[2];
    

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                result[0] = i;
                result[1] = map.get(complement);

            }

        }
        return result;
    }

   public static void main(String[] args) {

    int[] nums={1,2,3,7};


    int[] answer = twoSum2(nums, 5);
    System.out.println(answer[0]+","+answer[1]);

      
  }

    // public static <K, V> K getKey(Map<K, V> map, V value) {
 
    //     for (K key : map.keySet()) {
    //         if (value.equals(map.get(key))) {
    //             return key;
    //         }
    //     }
    //     return null;
    // }
 
    
}
