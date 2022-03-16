package Ch3_5;

import java.util.Arrays;

public class MyArrayList <E> {

    private static final int INIT_CAPACITY = 10;
    private E [] theData;
    private int size;
    private int capacity = INIT_CAPACITY;
    
    public MyArrayList(){
        theData = (E []) new Object [INIT_CAPACITY];
        size = 0;
        //capacity = INIT_CAPACITY;

    }

    public void add(int index, E anEntry){
        if( index < 0 || index > size ){ // error or exception //exception handling
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size >= capacity){
            reallocate();
        }
        for(int i=size-1; i>=index; i--){
            theData[i+1] = theData[i];
        
        }
        theData[index] = anEntry;

    }
    
    public void reallocate(){
        capacity *=2;
        theData = Arrays.copyOf(theData, capacity);
        // E [] tmp = (E []) new Object [capacity * 2];
    }

    public void add(E anEntry){
    }

    public static void main(String [] args){
        MyArrayList<String> test = new MyArrayList<>();

        try{

            test.add(1,"Hello");
        }
        catch( ArrayIndexOutOfBoundsException e){
            System.out.println("-----------");
        }

        System.out.println("*************");
      

    }
    
}
