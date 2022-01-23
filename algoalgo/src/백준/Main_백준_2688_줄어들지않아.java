package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_2688_줄어들지않아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 1 <= T <= 1,000
		
		long[][] dp = new long[65][10]; // dp[i][j] : i는 자리 수, j는 시작하는 수

		// 1자리는 모두 1개
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// N자리의 S로 시작하는 수에 대한 줄어들지 않는 수의 개수는
		// (N - 1)자리의 S로 시작하는 수부터 (N - 1)자리의 9까지의 줄어들지 않는 수의
		// 개수를 더하면 된다.
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
					dp[i][j] += dp[i-1][k]; // 점화식
				} 
			}
		}

		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //1 <= n <= 64
			long ans = 0;

			for (int i = 0; i <= 9; i++) {
				ans += dp[N][i];
			}

			sb.append(ans + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	} // end of main

} // end of class
