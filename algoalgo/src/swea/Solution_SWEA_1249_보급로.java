package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution_SWEA_1249_보급로
 * @author 이채윤
 * bfs: 메모리 초과
 */
public class Solution_SWEA_1249_보급로 {
	private static int N;
	private static int[][] map, dp;
	private static boolean[][] visited;
	private static final int MAX = Integer.MAX_VALUE;

	//출발지에서 도착지까지 가는 경로 중에 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간을 출력
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N   = Integer.parseInt(br.readLine()); // 배열의 크기
			map = new int[N][N];
			dp  = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
					dp[i][j]  = MAX; // 가장 큰 수로 저장해주기
				}
			} // end of for:input
			/* debug
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			*/
			
			min = MAX;
			visited = new boolean[N][N];
			dp[0][0] = map[0][0];
			go();
			
			//System.out.println(min);
			sb.append("#").append(testCase).append(" ").append(min).append("\n"); //출력
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	static int[] dr = {-1,1,0,0}; //하우
	static int[] dc = {0,0,-1,1};
	static int min;
 	/** bfs */
	private static void go() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[]{0,0}); // 시작점
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll(); // 꺼내기
			int r = current[0];
			int c = current[1];
			
			if(r==N-1 && c ==N-1) { // 도착지에 도달한 경우 최솟값 비교
				min = Math.min(min, dp[N-1][N-1]);
			}
			
			if(min <= dp[r][c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>= N || nc<0 || nc>=N) continue; // 범위를 벗어난 경우
				
				if(!visited[nr][nr] || dp[nr][nc] > dp[r][c] + map[nr][nc]) { // 방문하지 않은 경우 이동
					visited[nr][nc] = true;
					dp[nr][nc] = dp[r][c] + map[nr][nc]; // 걸리는 시간 더해주기
				
					q.add(new int[] {nr,nc});
				}
			} // end of for:4방
		}
	}
	
} // end of class
