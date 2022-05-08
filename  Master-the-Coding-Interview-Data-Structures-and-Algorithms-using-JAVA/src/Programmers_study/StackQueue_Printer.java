package Programmers_study;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQueue_Printer {

 
        class Node {
            int firstIndex;
            int prior;
            int lastIndex;
        }
        
        public int solution(int[] priorities, int location) {
            int answer = 0;
            List<Node> solList = new LinkedList<Node>();
            for(int i = 0; i < priorities.length; i++){
                Node newNode = new Node();
                newNode.firstIndex = i;
                newNode.prior = priorities[i];
                solList.add(newNode);
            }

            //정렬 - 선택
            for(int i = 0; i < solList.size();i++){
                for(int j = 1; j < solList.size(); j++){
                    Node com = solList.get(0);
                    Node com2 = solList.get(j);
                    if(com.prior < com2.prior){
                        //비교 아이템을 꺼내서 맨뒤로 보내 버리기
                        solList.add(com);
                        solList.remove(i);
                        break;

                    }
                    System.out.println("두번째 포문 끝 부분");
            
                }
            
            }

            // 검색
            // firstIndex 이 location인 아이템의 현재 index 찾기
            for(int i = 0; i < solList.size();i++){
                Node com = solList.get(i);
                if(com.firstIndex == location){
                    answer = i+1;
                }
            }


            
            return answer;
        }

        public static int solution2(int[] priorities, int location) {
            // 작업목록을 Queue에 초기화
            Queue<Integer> q = new LinkedList<>();
            for (int priority : priorities)
                q.offer(priority);
            int cnt=0;
            // location을 기록하면서 반환개수 count
            while(!q.isEmpty()){
                // poll과 count
                if(Collections.max(q) == q.peek()){// 최상위 우선순위면 빼주면서 count
                    if(location==0) // 결과 반환
                        return cnt;
                    else{
                        cnt++;
                        q.poll();
                    }
                }else{ // 우선순위가 아니면 뒤로 넣기
                    q.add(q.poll());
                }
                // 위치 기록
                if(location!=0)
                    location--;
                else
                    location = q.size()-1;
            }
            return 0;
        }

        public static void main(String[] args) {
            StackQueue_Printer a = new StackQueue_Printer();
            int[] array = {2, 1, 3, 2};
            int real = a.solution( array ,2);
            System.out.println(real);


        }
    
    
}
