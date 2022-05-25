package Sec11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11724_ConnectedComponent {

    static ArrayList<Integer>[] A; //그래프 데이터 저장 인접 리스트
    static boolean visited[]; //방문 기록 저장 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 갯수
        int m = Integer.parseInt(st.nextToken()); //에지 개수

        A = new ArrayList[n+1];
        visited = new boolean[n+1];


                
       
        for(int i = 1; i < n+1; i++){        // 인접 리스트 초기화 
            A[i] = new ArrayList<Integer>(); 
        }
        for(int i = 0; i < m; i++){         // 인접 리스트에 그래프 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()); 
            A[s].add(e);  // 양방향 에지이므로 양쪽에 에지를 더하기
            A[e].add(s); 
        }



        int count = 0; // 연결 요소 갯수
        for(int i = 1; i < n +1; i++){
            if(!visited[i]){  //방문하지 않은 노드가 있으면
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
        
    }

    public static void dfs(int v){
        if(visited[v]){
            return;
        }

        visited[v] = true;
        for(int i: A[v]){
            if(visited[i] == false){ 
                // 연결 노드 중 방문하지 않았던 노드만 탐색하기
                dfs(i);
            }
        }
    }

    
}
