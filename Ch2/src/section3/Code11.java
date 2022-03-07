package section3;

import java.util.Scanner;

public class Code11 {

     Polynomial3 [] polys = new Polynomial3 [100];
     int n = 0;

    public  void processCommand(){
        Scanner kb = new Scanner( System.in );
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("create")) {
                char name = kb.next().charAt(0);
                polys[n] = new Polynomial3(name);
               
                n++;

            }
            else if(command.equals("add")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    polys[index].addTerm( c, e);
                }

            }
            else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else{
                    int x = kb.nextInt();
                    int result = polys[index].calcPolynomial( x );
                    System.out.println(result);
                }
            }
            else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else{
                    polys[index].printPolynomial();
                }
            }
            else if (command.equals("exit")) {
                break;
            }
        }
        kb.close();

    }

 
    
    private  int find(char name){
        for(int i =0; i<n; i++){
            if(polys[i].name ==name){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        //main함수 안에서 자기자신을 포함하는 클래스의 객체를 생성 
        //원래 메인함수가 할일을 다른 non-static 메소드가 받게 한다
        //main메소드안 코드를 줄일수 있다. 
        Code11 app = new Code11();   
        app.processCommand();
    }

    
    
}
