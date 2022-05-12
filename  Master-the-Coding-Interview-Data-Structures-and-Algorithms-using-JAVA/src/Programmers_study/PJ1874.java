package Programmers_study;

import java.util.Scanner;
import java.util.Stack;

public class PJ1874 {

    // 2020.5.12 - 거의 보고 풀었다. 어렵다 우선 문제 개념이 이해하기 힘들었다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        sc.close();
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        int num = 1; // 오름차순으로 늘어날 자연수

        boolean result = true;
        for(int i = 0; i < A.length; i++){
            int su =  A[i]; // 현재 수열의 수
            if(su >= num ){
                while( su >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");

            } else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }

            }
            
        }
        if(result) System.out.println(bf.toString());
        
        
    }
    
}
