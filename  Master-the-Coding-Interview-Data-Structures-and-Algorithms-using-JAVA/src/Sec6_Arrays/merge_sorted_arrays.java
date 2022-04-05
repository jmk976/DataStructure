package Sec6_Arrays;
/*.............. Merge Sorted Arrays ..............*/
// merge two sorted arrays so that final result is a merged sorted array.
// example: [0,3,4,31] and [4,6,30] when merged gives output:
// [0, 3, 4, 4, 6, 30, 31]

import java.util.Arrays;

public class merge_sorted_arrays {

    public int[] mergeArrays( int[] arr1, int[] arr2){
        // i is index count of arr1
        // j is index count of arr2
        // k is index count of mergedArray
        int i = 0, j = 0, k = 0;

        int mergedLength = arr1.length + arr2.length;

        int[] mergedArray = new int[mergedLength]; 
        

        while( i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while( i < arr1.length ){
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        while( j < arr2.length ){
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }


         
        return mergedArray;
    }
    
    public static void main(String[] args) {  
        
        merge_sorted_arrays arrays = new merge_sorted_arrays();
        int[] arr3 = arrays.mergeArrays(new int[]{0,3,4,5}, new int[]{4, 6, 30});
        System.out.println(Arrays.toString(arr3));
    
      

    }
}
