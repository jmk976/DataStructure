package Sec6_Arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2443_stars {
    public static void main(String[] args) throws NumberFormatException, IOException {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());

        for(int i = N-1; i >= 0 ; i--) {

            for(int j = (N-1) ; j > i ; j--) {
            
				sb.append(" ");
			}
            
			for(int j = i ; j <= (i*2) ; j++) {
				sb.append("*");
			}

            

			sb.append("\n");
		}
		System.out.println(sb);



    }
    
}
