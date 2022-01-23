package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_15988_123더하기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long dp[] = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		//dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		for (int testCase = 0; testCase < T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 4; i <= n; i++) {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
			}
			
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
