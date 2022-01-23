package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기 {
	static int N, M, r, c, d, answer;
	static int[][] map;
	static boolean[][] visited;
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
		
		answer = 0; // 정답
		
		clean(r,c,d); // 청소
		
		System.out.println(answer);
	} // end of main
	
	/** 청소 */
	private static void clean(int r, int c, int d) {
		boolean flag = false;
		
		if(!visited[r][c]) { // 방문하지 않은 경우
			visited[r][c] = true;
			answer++;
		}
		
		for (int i = 0; i < 4; i++) { // 방향 탐색
			d = dirRotate(d);
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(map[nr][nc] == 0 && !visited[nr][nc]) {
				clean(nr, nc, d);
				flag = true;
				break;
			}
		}
		
		
		if(flag == false) { // 모두 청소가 되어있거나 벽인 경우
			int nr = r - dr[d];
			int nc = c - dc[d];
			
			if(map[nr][nc] == 0) {
				clean(nr, nc, d);
			}
		}
	}
	
	/** 방향 회전*/
	private static int dirRotate(int d) {
		int result = -1;
		switch (d) {
		case 0: // 북쪽에서 왼쪽->서
			result = 3;
			break;
		case 1: // 동쪽에서 왼쪽 -> 남
			result = 0;
			break;
		case 2: // 남쪽에서 왼쪽 -> 동
			result = 1;
			break;
		case 3: // 서쪽에서 왼쪽 -> 북
			result = 2;
			break;
		}
		
		return result;
	}
}
