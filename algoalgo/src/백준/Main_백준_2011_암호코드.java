package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2011_암호코드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String code = br.readLine(); // 입력받은 암호코드
		int length = code.length();  // 코드 길이
		long[] dp = new long[length+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		if(code.charAt(0) == '0') {
			System.out.println(0);
		}
		else if(code.charAt(length-1) == '0' 
				&& code.charAt(length-2) != '1'
				&& code.charAt(length-2) != '2') {
			System.out.println(0);
		}
		else {
			for (int i = 2; i <= length; i++) {
				int temp = Integer.parseInt(code.charAt(i-1) + "");
				if(temp > 0 ) {
					dp[i] = dp[i-1] % 1000000;
				}
				
				temp += Integer.parseInt(code.charAt(i-2) + "") * 10;
				if(10 <= temp && temp <= 26) {
					dp[i] = (dp[i]+dp[i-2]) % 1000000;
				}
				
				System.out.println(dp[length]);
			}
		}
		
	}
}
