package Sec7_Hash_table;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine){
        for( char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c);
            if(index == -1){
                return false;
            }
            magazine = magazine.substring(0, index) + magazine.substring(index +1);
        }
        return true;
    }

    private Map<Character, Integer> makeCountsMap(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: s.toCharArray()){
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount +1);
        }
        return counts;
    }

    public boolean canConstruct2(String ransomNote, String magazine){
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> ransomNoteCounts = makeCountsMap(ransomNote);
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        for(char c : ransomNoteCounts.keySet()){
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            int countInRansomNote = ransomNoteCounts.get(c);
            if(countInMagazine < countInRansomNote){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
       RansomeNote rn = new RansomeNote();
        System.out.println(rn.canConstruct2("ilow", "iloveu"));
       
      }
    
    
}
