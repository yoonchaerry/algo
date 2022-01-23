package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_����_9456_��ƼĿ
 * @author leech
 */
public class Main_����_9456_��ƼĿ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽�
		for (int testCase = 0; testCase < T; testCase++) {
			int n = Integer.parseInt(br.readLine()); // n���� ����, 1<=n<=100,000
			int[][] stickers = new int[3][n+1];
			int[][] dp 		 = new int[3][n+1];
			for (int i = 1; i <= 2; i++) { // ��
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= n; j++) { // ��
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][1] = stickers[1][1];
			dp[2][1] = stickers[2][1];
			
			for (int i = 2; i <= n; i++) {
				// �����¿� ��ƼĿ�� ��� ����
				// �밢�� ��ġ�� �ִ� ��ƼĿ�� ����ؾ���
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + stickers[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[2][i];
				
			}
			
			sb.append(Math.max(dp[1][n], dp[2][n])).append("\n");
		} // end of testcase
		
		System.out.println(sb.toString());
		
	} // end of main
} // end of class
