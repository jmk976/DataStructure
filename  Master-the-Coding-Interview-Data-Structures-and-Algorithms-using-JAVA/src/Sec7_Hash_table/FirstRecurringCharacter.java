package Sec7_Hash_table;

import java.util.HashSet;

//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined
 

public class FirstRecurringCharacter {
   
    public Integer FirstRecurringCharacter(int[] arr){
      

        HashSet<Integer> hashSet = new HashSet<>();

        for(int element : arr){
            if(hashSet.contains(element)){
                return element;
            } else {
                hashSet.add(element);
            }
        }
    return null;
      
    }


    
    public static void main(String[] args) {

        FirstRecurringCharacter fr = new FirstRecurringCharacter();

        int[] arr = {2,1,1,2,3,5,1,2,4};

        System.out.println(fr.FirstRecurringCharacter(arr));
        
      }
    
}
