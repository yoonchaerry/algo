package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구글링해서 풀었다..
 * @author leech
 */
public class Main_백준_11066_파일합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // testcase
		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine()); // 장의 수K (3 ≤ K ≤ 500)
			int[]   files = new int[K+1];
			int[]   sum   = new int[K+1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= K; i++) { // 10,000을 초과하지 않는다.
				files[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + files[i];
			} // 파일의 크기
						
			// K + 1의 크기로 하면 밑의 for문에서 dp[k + 1][i]에서 예외가 발생하기 때문에 K + 1로 함
            int[][] dp = new int[K + 2][K + 2];
			
			for (int i = 2; i <= K; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;					
                    for (int k = j; k <= i; k++) {
                        // dp[j][i]는 j번째부터 i번째까지 합치는데 드는 최소 비용
                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                    }
                    // sum[i] - sum[j - 1]는 파일 i번째부터 j까지의 부분 합
                    dp[j][i] += sum[i] - sum[j - 1];
                }
            }
			
            System.out.println(dp[1][K]);
		} // end of for testcase

	} // end of main
} // end of class
