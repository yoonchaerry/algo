package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ����_11057_��������
 * @author ä��
 * ���� Ʋ������..?
 */
public class Main_����_11057_�������� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ����
		
		int[][] dp = new int [N+1][10];
		
		for (int i = 0; i < 10; i++) { // �ʱ�ȭ, ���ڸ� ������ ���� ��� 1
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
