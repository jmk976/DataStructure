package Sec6_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2441_stars {
    public static void main(String[] args) throws NumberFormatException, IOException {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());

        for(int i = N; i > 0 ; i--) {

            for(int j = N-i ; j > 0 ; j--) {
				sb.append(" ");
			}
            
			for(int j = i ; j > 0 ; j--) {
				sb.append("*");
			}

			sb.append("\n");
		}
		System.out.println(sb);



    }
    
}
