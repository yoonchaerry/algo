package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 계단 수
		int[] stairs = new int[N+1];
		int[] dp 	 = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(stairs[i]+" ");
		}
		System.out.println();
		
		dp[1] = stairs[1];
		
		if(N >= 2) { // N이 1일수도 있으니까
			dp[2] = stairs[1] + stairs[2];
		}
		
		//즉, 현재 인덱스 i 에 대해 두 칸 전(i - 2)의 '메모이제이션 값'과 첫 칸 전(i - 1)의 값 + 셋 째칸 전(i - 3)의 '메모이제이션 값' 중 
		//큰 값을 현재 i 계단의 값과 합하여 DP배열에 저장(Memoization)을 해주면 된다.
		for (int i = 3; i <= N; i++) { 
			// 연속된 세계의 계단을 밟을 수 없다.
			// 두칸전 값과 첫칸 전 + 셋째칸 전 비교가 필요
			dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[N]);
		
	} // end of main

} // end of class
