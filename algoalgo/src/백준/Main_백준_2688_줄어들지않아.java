package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_����_2688_�پ�����ʾ� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� 1 <= T <= 1,000
		
		long[][] dp = new long[65][10]; // dp[i][j] : i�� �ڸ� ��, j�� �����ϴ� ��

		// 1�ڸ��� ��� 1��
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// N�ڸ��� S�� �����ϴ� ���� ���� �پ���� �ʴ� ���� ������
		// (N - 1)�ڸ��� S�� �����ϴ� ������ (N - 1)�ڸ��� 9������ �پ���� �ʴ� ����
		// ������ ���ϸ� �ȴ�.
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
					dp[i][j] += dp[i-1][k]; // ��ȭ��
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
