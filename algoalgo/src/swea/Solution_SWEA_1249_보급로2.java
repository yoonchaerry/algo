package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution_SWEA_1249_보급로
 * @author 이채윤
 * 다익스트라
 */
public class Solution_SWEA_1249_보급로2 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static final int INF = Integer.MAX_VALUE;
	static int[] dr = {-1,1,0,0}; //하우
	static int[] dc = {0,0,-1,1};

	//출발지에서 도착지까지 가는 경로 중에 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간을 출력
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N   = Integer.parseInt(br.readLine()); // 배열의 크기
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine(); // 비용 0~9
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			} // end of for:input			
			
			sb.append("#").append(testCase).append(" ").append(dijkstra(0,0)).append("\n"); //출력
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	/**다익스트라*/
	private static int dijkstra(int startR, int startC) { // 출발지 r,c
		boolean[][] visited = new boolean[N][N]; // 방문배열
		int[][]  	minTime  = new int[N][N]; 	  // 최소비용 저장
		
		// 최소비용을 찾아야하니까 최댓값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		minTime[startR][startC] = 0; // 출발지에서의 비용은 0
		
		int r = 0, c = 0, minCost = 0, nr,nc;
		while(true) {
			// step1 출발지->자신 비용이 최소인 것 선택
			
			
			minCost = INF;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && minCost > minTime[i][j] ) {
						minCost = minTime[i][j];
						r = i;
						c = j;
					}
				}
			}
			
			
			if(visited[r][c]) continue; // PQ
			visited[r][c] = true; // 방문처리
			if(r==N-1 && c==N-1) return minCost; // 도착지
			
			// step2 : step1 에서 선택된 정점을 경유지로 해서 인접정점 따져보기
			// 이 문제는 인접 4방
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] 
						&& minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
				}
			}
		} // end of while
			
	} // end of dijkstra
	

} // end of class
