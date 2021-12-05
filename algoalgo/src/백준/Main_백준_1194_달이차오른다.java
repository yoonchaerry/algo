package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_����_1194_������������ {

	private static int N, M, cnt;
	private static char[][] map;
	private static boolean[] key;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ���� 1 �� N, M �� 50
		M = Integer.parseInt(st.nextToken()); // ����
		
		map = new char[N][M]; // �迭 ����
		int r = 0; // �ν��� ��ġ
		int c = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char input = s.charAt(j);
				map[i][j] = input;
				
				if(input == '0') { // �ν��� ��ġ ����
					r = i;
					c = j;
				}
				
			}
		} // end of for input
		
		key = new boolean[6]; // abcdef
		visited = new boolean[N][M];
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		go(r, c);
		
		System.out.println(cnt);
		
	} // end of main
	
	static int[] dr = {-1,1,0,0}; // �����¿�
	static int[] dc = {0,0,-1,1}; // �����¿�
	/** bfs */
	private static void go(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			
			if(map[cr][cc] == '1') {
				cnt++;
				return;
			}
			
			for (int d = 0; d < 4; d++) { // 4���� �̵�
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#' || visited[nr][nc] ) continue;
				
				if( 0<=map[nr][nc]-'a' && map[nr][nc]-'a'<=5) { // �����ΰ�� ����
					//System.out.println(map[nr][nc]);
					key[map[nr][nc]-'a'] = true;
					visited[nr][nc] = true;
					cnt++;
				}
				else if( 0<=map[nr][nc]-'A' && map[nr][nc]-'A'<=5) { // ���ΰ�� �� �� �ֳ� ����
					int door = map[nr][nc] -'A';
					
					if(key[door]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
						cnt++;
					}
				}
				else {
					visited[nr][nc] = true;
					q.add(new int[] {nr,nc});
					cnt++;
				}
			}
		}
		
		if(cnt == 0) {
			cnt = -1;
		}
		
	}

} // end of class
