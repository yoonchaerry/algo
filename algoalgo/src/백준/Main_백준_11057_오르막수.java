package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준_11057_오르막수
 * @author 채리
 * 뭐가 틀린거지..?
 */
public class Main_백준_11057_오르막수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 길이
		
		int[][] dp = new int [N+1][10];
		
		for (int i = 0; i < 10; i++) { // 초기화, 한자리 숫자인 경우는 모두 1
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < N+1; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) { 
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer%10007);
	} // end of main
} // end of class
