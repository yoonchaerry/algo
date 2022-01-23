package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_14503_�κ�û�ұ�2 {
	static int N, M, r, c, d, answer;
	static int[][] map;
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
		
		answer = 1; // ����
		
		dfs(r,c,d); // û��
		
		System.out.println(answer);
	} // end of main
	
	/** û�� */
	private static void dfs(int r, int c, int d) {
		map[r][c] = 2; // û�� �Ϸ�
		
		for (int i = 0; i < 4; i++) { // ���� Ž��
			d -= 1; // ���� �������� ���鼭 Ž��
			if(d == -1) d = 3;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] == 0) {
					answer++;
					dfs(nr, nc, d);
					return;
				}
			}
		} // end of for:����Ž��
		
		// �� �̻� û���� ������ ����. c,d
		int nd = (d + 2) % 4; // �ݴ�������� ����
		int br = r + dr[nd];
		int bc = c + dc[nd];
		if(br>=0 && br<N && bc>=0 && bc>M && map[br][bc] != 1) {
			dfs(br, bc, d); // ������ �� ������ �����ؾ��Ѵ�.
		}
	}
}
