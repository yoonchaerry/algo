package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Solution_SWEA_1953_탈주범검거
 * @author 이채윤
 * 해보자고!
 */
public class Solution_SWEA_1953_탈주범검거 {
	static int[][] dr = {{},{1,-1,0,0}, {1,-1}, {0,0},{-1,0},{1,0}, {1,0},{-1,0}}; // 상하좌우, 상하, 좌우, 상우, 하우, 하좌, 상좌
	static int[][] dc = {{},{0,0,-1,1}, {0,0}, {-1,1}, {0,1},{0,1},{0,-1},{0,-1}};
	static int N, M, R, C, L, map[][]; // input
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 세로 크기 N, 5 ≤ N, M ≤ 50
			M = Integer.parseInt(st.nextToken()); // 가로 크기 M
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 세로 위치 R, 0 ≤ R ≤ N-1, 0 ≤ C ≤ M-1
			C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 가로 위치 C
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간 L, 1 ≤ L ≤ 20
			
			map = new int[N][M];
			ArrayList<Tunnel> tunnelList = new ArrayList<Tunnel>(); // 터널 정보 저장
			for (int i = 0; i < N; i++) { // 행
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) { // 열
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					
					if(num != 0) {
						tunnelList.add(new Tunnel(i, j, num));
					}
				}
			} // end of for:input
			
			/*
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			*/
			
			sb.append("#").append(testCase).append(" ").append(find()).append("\n");
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	/**find : bfs*/
	private static int find() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M]; // 방문 배열
		
		q.offer(new int[] {R,C,map[R][C], L}); // r,c,터널 타입
		visited[R][C] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0], c = current[1], type = current[2], l = current[3];
			
			if(l == 1) break;
			
			for (int i = 0; i < dr[type].length; i++) { // 터널 타입에 따라 탐색 횟수가 다름
				int nr = r + dr[type][i];
				int nc = c + dc[type][i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != 0 && !visited[nr][nc] && isAvailable(type, map[nr][nc])) { // 범위에 있고, 방문하지 않은 경우, 터널이 있는 경우
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,map[nr][nc], l-1});
					cnt++;
										
					//System.out.println(r+","+c+"(" + type + ")->" + nr +"," + nc  + "("+map[nr][nc]+ ") l="+(l-1));
				}
			}			
		}
		//System.out.println(cnt);
		return cnt;
	}
	
	/**연결 가능한지 체크 */
	private static boolean isAvailable(int typeA, int typeB) {
		for (int i = 0; i < dr[typeA].length; i++) {
			for (int j = 0; j < dr[typeB].length; j++) {
				if(dr[typeA][i] ==  dr[typeB][j] * -1) return true;
			}
		}
		
		for (int i = 0; i < dc[typeA].length; i++) {
			for (int j = 0; j < dc[typeB].length; j++) {
				if(dc[typeA][i] ==  dc[typeB][j] * -1) return true;
			}
		}
		
		return false;
	}
	
	/** 터널 클래스 */
	static class Tunnel{
		int r,c;  // 터널 좌표
		int type; // 터널 타입
		public Tunnel(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	} // end of Tunnel

} // end of class
