package Sec6_Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        //self 1st trial
        //accepted but time limit exceeded
        //Time complexity: O(n^2)
        //Space complexity: O(1)O(1).
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j <nums.length; j ++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        //self 2nd  trial
        //accepted but time limit exceeded
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         for(int i = 0; i < nums.length; i++){
             
             map.put(i , nums[i]);
         }
         
          for(int j = 0; j < nums.length; j++){
              map.remove(j);
              
              if(map.containsValue(nums[j]) ){
                  return true; 
              }
          }
       
         
         return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        //Approach #2 (Sorting) [Accepted]
        //내장되어있는 sort 함수를 쓴다!
        //Time complexity: O(nlogn). Sorting is O(nlogn) and the sweeping is O(n). 
        //The entire algorithm is dominated by the sorting step, which is O(nlogn).
        //Space complexity: O(1).
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] == nums[i + 1]){
                return true;
            }

        }
        return false;
    }

    public boolean containsDuplicate4(int[] nums) {
        //Approach #3 (Hash Table) [Accepted]
        // dynamic sets such as Binary Search Tree and Hash Table - 나중에 공부하고 다시 보기
        // search(), insert()
        //Time complexity: O(nlogn). Sorting is O(nlogn) and the sweeping is O(n). 
        //The entire algorithm is dominated by the sorting step, which is O(nlogn).
        //Space complexity: O(1).
       Set<Integer> set = new HashSet<>(nums.length);
       for(int x: nums){
           if(set.contains(x)) return true;
           set.add(x);
       }
       return false;
    }
    



    
}
