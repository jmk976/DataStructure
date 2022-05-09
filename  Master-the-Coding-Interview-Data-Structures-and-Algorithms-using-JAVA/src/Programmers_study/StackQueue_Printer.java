package Programmers_study;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class StackQueue_Printer {

 
        class Node {
            int firstIndex;
            int prior;
            int lastIndex;
        }
        
        public int solution(int[] priorities, int location) {
            //첫시도.. 2개중 1개만 통과했다..
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
            //프로그래머스에서 젤 위에 있는 풀이 인데 와닿지가 않음..
            int answer = 0;
            int l = location;
    
            Queue<Integer> que = new LinkedList<Integer>();
            for(int i : priorities){
                que.add(i);
            }
    
            Arrays.sort(priorities);
            int size = priorities.length-1;
    
    
    
            while(!que.isEmpty()){
                Integer i = que.poll();
                if(i == priorities[size - answer]){
                    answer++;
                    l--;
                    if(l <0)
                        break;
                }else{
                    que.add(i);
                    l--;
                    if(l<0)
                        l=que.size()-1;
                }
            }
    
            return answer;
        }

        class Printer {
            //요소를 넣고 빼면 원래 위치를 알 수 없으니 class를 하나 만들어서 우선순위와 처음 위치 저장
            int location;
            int prior;
            
            Printer (int location, int prior) {
                this.location = location;
                this.prior = prior;
            }
        }

        public int solution3(int[] priorities, int location) {
            //맨 앞 요소를 빼서 사용 -> 큐
            int answer = 0;
          
            Queue<Printer> q = new LinkedList<>();
            //작업목록을 큐에 초기화
            for (int i=0; i<priorities.length; i++) {

                q.add(new Printer(i, priorities[i]));
            }
            
            while (!q.isEmpty()) {
                //첫번째 요소의 우선순위
                int num = q.peek().prior;
                boolean flag = false;
                
                for (Printer p : q) {
                    //첫번째 요소 우선순위보다 큰 우선순위가 있는지 for문 돌려 확인
                    if (p.prior > num) {
                        //있을 경우,  flag를 true로 바꾸고.
                        flag = true;
                    }
                }
                
                if (flag) {
                    //있을 경우, 첫번째 요소를 삭제하면서 반환시켜서 끝에 추가
                    q.add(q.poll());
                } else {
                    //없는 경우, 
                    //첫번째 요소 위치와 내가 찾고싶은 문서의 처음 위치 비교할때, poll이 작용해 첫번째 요소 제거됨(인쇄됨)
                    if (q.poll().location == location) { 
                        //같을 경우에, 원래의 요소 배열 크기 와 현재 큐의 크기를 비교해 
                        //원하는 요소가 몇번째로 제거된 건지(인쇄된 건지)를 answer에 담는다. 
                     
                        answer = priorities.length - q.size();
                    }
                }
                
            }
            
            
            return answer;
        }


        public int solution4(int[] priorities, int location) {
     
            Queue<Printer> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int count = 1;
            //들어온 순서와 우선순위를 함께 queue에 저장
            //문서의 우선순위 확인을 위해 priorityQueue를 이용
            for (int i=0; i<priorities.length; i++) {

                q.add(new Printer(i, priorities[i]));
                pq.add(priorities[i]);
            }

            
            while (!q.isEmpty()) {
                //현재 프린트하려는 문서의 우선순위보다 높은 수선순위를 문서가 없는지 확인
                if(q.peek().prior == pq.peek()){
                    //순서를 확인하려는 문서인지 체크
                    if(q.peek().location == location){
                        //동일하면 바로 출력
                        return count;
                    }
                    //순서를 확인하려는 문서가 아니라면 큐에서 제거해 주고 순서를 증가 시켜줌
                    q.poll();
                    pq.poll();
                    count++;
                } else{ // 더 높은 우선순위의 문서가 존재할 경우, 해당 문서는 인쇄 요청의 마지막 순서로 돌아간다. 
                    
                    Printer p = q.poll();
                    q.add(p);
                }
            }
            return count;
             
        }
    
    
   
        

        public static void main(String[] args) {
            StackQueue_Printer a = new StackQueue_Printer();
            int[] array = {2, 1, 3, 2};
            int real = a.solution4( array ,2);
            System.out.println(real);


        }
    
    

}
