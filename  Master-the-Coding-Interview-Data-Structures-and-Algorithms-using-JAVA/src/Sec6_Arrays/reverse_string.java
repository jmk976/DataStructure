package Sec6_Arrays;


/*  ................  Reverse A String .................*/
// create a function that reverse a string:
// example: "Hello World" becomes "dlroW olleH"




public class reverse_string  {

    private static String reverse(String str) {

        String result="";//It's more recommended to use "StringBuilder" object when manipulating strings

        int totalItems = str.length()-1;

        for(int i = totalItems; i >=0; i--){
            result += str.charAt(i);
        }

        return result;
    } 
    //char result = myStr.charAt(0); 처럼  char의 타입으로 받고 char 타입을 string타입에 넣으려면 안들어가져지지만,
    //String 과  char이 합쳐지면, char이 String으로 convert해서 합쳐짐. 

    private static String reverse2(String str){
        StringBuilder temp = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i --){
            temp.append(str.charAt(i));

        }
        return temp.toString();
    }

    //String is immutable Object(불변 객체) 두개의 String을 더하면 새로운 String을 생성
    //즉, String 객체와 String객체를 더하면 메모리 할당과 메모리 해제를 발생시키며 더하는 연산이 많아진다면 성능적으로 좋지 않다. 
    //그래서 StringBuilder를 사용, 문자열 더한다면 객체를 생성하는 것이 아니라 기존 데이터에 더하는 방식
    //stringBuilder.append("문자열 ").append("연결");
   // String str = stringBuilder;  X // String에 StringBuilder를 그대로 넣을 순 없다. toString()을 붙여야 한다
   //String str = stringBuilder.toString();
   // 두 println()은 같은 값을 출력한다

    public static void main(String[] args) {   
    
       // String answer = reverse("hi my name is"); 
        String answer2 = reverse2("sweetdream");
        System.out.println(answer2);
    }
}
