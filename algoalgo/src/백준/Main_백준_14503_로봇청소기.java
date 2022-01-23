package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_14503_�κ�û�ұ� {
	static int N, M, r, c, d, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0}; // �ϵ�����
	static int[] dc = {0,1,0,-1}; // �ϵ�����	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ��, 3 �� N, M �� 50
		M = Integer.parseInt(st.nextToken()); // ��
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken()); // ��ǥ r
		c = Integer.parseInt(st.nextToken()); // ��ǥ c
		d = Integer.parseInt(st.nextToken()); // ���� (0��, 1��, 2��, 3��)
		
		// �� ĭ�� 0, ���� 1
		for (int i = 0; i < N; i++) { // ��
			String s = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx=+2) {// ��
				map[i][j] = s.charAt(idx) - '0';
			}
		}
		
		answer = 0; // ����
		
		clean(r,c,d); // û��
		
		System.out.println(answer);
	} // end of main
	
	/** û�� */
	private static void clean(int r, int c, int d) {
		boolean flag = false;
		
		if(!visited[r][c]) { // �湮���� ���� ���
			visited[r][c] = true;
			answer++;
		}
		
		for (int i = 0; i < 4; i++) { // ���� Ž��
			d = dirRotate(d);
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(map[nr][nc] == 0 && !visited[nr][nc]) {
				clean(nr, nc, d);
				flag = true;
				break;
			}
		}
		
		
		if(flag == false) { // ��� û�Ұ� �Ǿ��ְų� ���� ���
			int nr = r - dr[d];
			int nc = c - dc[d];
			
			if(map[nr][nc] == 0) {
				clean(nr, nc, d);
			}
		}
	}
	
	/** ���� ȸ��*/
	private static int dirRotate(int d) {
		int result = -1;
		switch (d) {
		case 0: // ���ʿ��� ����->��
			result = 3;
			break;
		case 1: // ���ʿ��� ���� -> ��
			result = 0;
			break;
		case 2: // ���ʿ��� ���� -> ��
			result = 1;
			break;
		case 3: // ���ʿ��� ���� -> ��
			result = 2;
			break;
		}
		
		return result;
	}
}
