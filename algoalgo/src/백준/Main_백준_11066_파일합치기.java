package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���۸��ؼ� Ǯ����..
 * @author leech
 */
public class Main_����_11066_������ġ�� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // testcase
		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine()); // ���� ��K (3 �� K �� 500)
			int[]   files = new int[K+1];
			int[]   sum   = new int[K+1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= K; i++) { // 10,000�� �ʰ����� �ʴ´�.
				files[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + files[i];
			} // ������ ũ��
						
			// K + 1�� ũ��� �ϸ� ���� for������ dp[k + 1][i]���� ���ܰ� �߻��ϱ� ������ K + 1�� ��
            int[][] dp = new int[K + 2][K + 2];
			
			for (int i = 2; i <= K; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;					
                    for (int k = j; k <= i; k++) {
                        // dp[j][i]�� j��°���� i��°���� ��ġ�µ� ��� �ּ� ���
                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                    }
                    // sum[i] - sum[j - 1]�� ���� i��°���� j������ �κ� ��
                    dp[j][i] += sum[i] - sum[j - 1];
                }
            }
			
            System.out.println(dp[1][K]);
		} // end of for testcase

	} // end of main
} // end of class
