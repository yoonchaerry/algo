package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����_1515_����ã��
 * @author leech
 * �÷��̵�ͼ�
 */
public class Main_����_1515_����ã�� {
	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ������ ����, 1��N��99
		int M = Integer.parseInt(st.nextToken()); // ���� ��
		int half = N/2; 
		int[][] beads = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			beads[a][b] = 1; // a>b
			beads[b][a] = -1;  // b<a
			
		} // end of input
		
		//������ ũ�ų�, ���� ������ ���� ���ݺ��� ������ �� ++
		for (int i = 1; i <= N; i++) { // �߰�
			for (int s = 1; s <= N; s++) { // ���
				for (int e = 1; e <= N; e++) { // ����
					// ������ ���谡 �ִ°�� �߰� ���谡 ������ ����� �ֱ�
					// ���(s)->�߰�(i)  == �߰�(i)->����(e) ->
					if(beads[e][i] != 0 && beads[s][i] == beads[i][e]) {
						beads[s][e] = beads[s][i]; // ���� �� �߰�
					}
				}
			}
		}

		int[] heavy = new int[N+1];
		int[] light = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// ���ſ� ������ ��� 
				if(beads[i][j] == 1) heavy[i]++;
				// ������ ������ ��� 
				if(beads[i][j] == -1) light[i]++;
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			// ���ݺ��� ������ ���� ������ �÷��ش�
			if(heavy[i] > half) answer++;
			if(light[i] > half) answer++;
		}
		
		System.out.println(answer);
	} // end of main

} // end of class
