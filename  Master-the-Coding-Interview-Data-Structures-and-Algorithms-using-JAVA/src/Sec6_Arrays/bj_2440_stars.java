package Sec6_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj_2440_stars {

    public static void starStamp(int n){
        for(int i = n; i > 0; i--){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println("");

        }

    }




    public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner scan = new Scanner(System.in);
        // int num = scan.nextInt();
        // starStamp(num);
        // scan.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());

        for(int i = N; i > 0 ; i--) {
			for(int j = i ; j > 0 ; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);



    }
    
}
