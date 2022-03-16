package Ch3_3;

public class Test {
    public int a =10;
    public double x = 1.23;

    public boolean equals( Object other ){ // Overriding //Test other 이 아닌 이유?
       //Test 타입으로 타입 변환
        Test other2 = (Test) other; //type casting
        return a == other2.a && x == other2.x;
    }

    public static void main(String[] args){
        Test test1 = new Test();
        Test test2 = new Test();

        System.out.println( test1.toString() );
        
        if( test2.equals(test1) ){
            System.out.println("yes");
        }     
        else  {
            System.out.println("no");
        } 
            
        Object[] array = new Object[100];
        int a =20;
       // Integer age = new Integer(a); //wrapping
        
        array[0] = a;  //autoboxing

       //   int b = age.intValue();  //unwrapping
       // int b = (Integer) array[0]; //unboxing

        String str ="1234";
        int c = Integer.parseInt(str); //데이터 타입간의 변화기능 제공
        System.out.println(c);

    }
    
}
