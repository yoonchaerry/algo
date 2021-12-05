package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1194_달이차오른다 {

	private static int N, M, cnt;
	private static char[][] map;
	private static boolean[] key;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 1 ≤ N, M ≤ 50
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new char[N][M]; // 배열 생성
		int r = 0; // 민식이 위치
		int c = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char input = s.charAt(j);
				map[i][j] = input;
				
				if(input == '0') { // 민식이 위치 저장
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
	
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1}; // 상하좌우
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
			
			for (int d = 0; d < 4; d++) { // 4방향 이동
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#' || visited[nr][nc] ) continue;
				
				if( 0<=map[nr][nc]-'a' && map[nr][nc]-'a'<=5) { // 열쇠인경우 줍줍
					//System.out.println(map[nr][nc]);
					key[map[nr][nc]-'a'] = true;
					visited[nr][nc] = true;
					cnt++;
				}
				else if( 0<=map[nr][nc]-'A' && map[nr][nc]-'A'<=5) { // 문인경우 열 수 있나 보자
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
