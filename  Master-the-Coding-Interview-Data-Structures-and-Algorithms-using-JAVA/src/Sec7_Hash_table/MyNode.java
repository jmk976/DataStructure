package Sec7_Hash_table;

public class MyNode{
    public String key;
    public int value;
  
    public MyNode(String key, int value){
      this.key = key;
      this.value = value;
    }
  
    public String getKey(){
      return key;
    }
    public void setKey(String key){
      this.key = key;
      
    }
  
     public int getValue(){
      return value;
    }
  
    public void setValue(int value){
      this.value = value;
    }
  
    
    
  }