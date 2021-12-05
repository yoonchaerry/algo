package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_����_2579_��ܿ����� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ��� ��
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
		
		if(N >= 2) { // N�� 1�ϼ��� �����ϱ�
			dp[2] = stairs[1] + stairs[2];
		}
		
		//��, ���� �ε��� i �� ���� �� ĭ ��(i - 2)�� '�޸������̼� ��'�� ù ĭ ��(i - 1)�� �� + �� °ĭ ��(i - 3)�� '�޸������̼� ��' �� 
		//ū ���� ���� i ����� ���� ���Ͽ� DP�迭�� ����(Memoization)�� ���ָ� �ȴ�.
		for (int i = 3; i <= N; i++) { 
			// ���ӵ� ������ ����� ���� �� ����.
			// ��ĭ�� ���� ùĭ �� + ��°ĭ �� �񱳰� �ʿ�
			dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[N]);
		
	} // end of main

} // end of class
