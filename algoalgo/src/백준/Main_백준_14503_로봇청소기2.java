package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기2 {
	static int N, M, r, c, d, answer;
	static int[][] map;
	static int[] dr = {-1,0,1,0}; // 북동남서
	static int[] dc = {0,1,0,-1}; // 북동남서	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행, 3 ≤ N, M ≤ 50
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken()); // 좌표 r
		c = Integer.parseInt(st.nextToken()); // 좌표 c
		d = Integer.parseInt(st.nextToken()); // 방향 (0북, 1동, 2남, 3서)
		
		// 빈 칸은 0, 벽은 1
		for (int i = 0; i < N; i++) { // 행
			String s = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx=+2) {// 열
				map[i][j] = s.charAt(idx) - '0';
			}
		}
		
		answer = 1; // 정답
		
		dfs(r,c,d); // 청소
		
		System.out.println(answer);
	} // end of main
	
	/** 청소 */
	private static void dfs(int r, int c, int d) {
		map[r][c] = 2; // 청소 완료
		
		for (int i = 0; i < 4; i++) { // 방향 탐색
			d -= 1; // 왼쪽 방향으로 돌면서 탐색
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
		} // end of for:방향탐색
		
		// 더 이상 청소할 공간이 없다. c,d
		int nd = (d + 2) % 4; // 반대방향으로 후진
		int br = r + dr[nd];
		int bc = c + dc[nd];
		if(br>=0 && br<N && bc>=0 && bc>M && map[br][bc] != 1) {
			dfs(br, bc, d); // 후진할 때 방향을 유지해야한다.
		}
	}
}
