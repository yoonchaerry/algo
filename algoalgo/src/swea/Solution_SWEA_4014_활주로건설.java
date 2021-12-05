package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_Ȱ�ַΰǼ� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // testcase
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // ���� �Ѻ� ����, 6 �� N �� 20 
			int X = Integer.parseInt(st.nextToken()); // Ȱ�ַ��� ����,  2 �� X �� 4 
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) { // ��
				String h = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx += 2) { // ��
					map[i][j] = h.charAt(idx)-'0';
				}
			} // end of input
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		} // end of for:testcase

	} // end of main

} // end of class
