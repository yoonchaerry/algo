package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_5643_키순서
 * @author 이채윤
 * bfs..
 */
public class Solution_SWEA_5643_키순서 {

	private static int N, M, tCnt, sCnt;
	private static int[][] adj;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 1 ≤ T ≤ 15
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine()); // 학생의 수, 2 ≤ N ≤ 500
			M = Integer.parseInt(br.readLine()); // 비교 횟수, 0 ≤ M ≤ N*(N-1)/2
			adj = new int[N+1][N+1];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to   = Integer.parseInt(st.nextToken());
				
				adj[from][to] = 1;
			} // input
			/*
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(adj[i][j] + " ");
				}
				System.out.println();
			} // debug
			*/
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				tCnt = 0; // 자기보다 큰
				sCnt = 0; // 자기보다 작은
				
				findTall(i);
				findSmall(i);
				
				// 큰 + 작은 = 총학생 - 1 이면 순서 알 수 있음
				if(tCnt+sCnt == N-1) answer++;
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");			
			
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	/** 나보다 큰 사람 찾기 */
	private static void findTall(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[current][i] == 1) { // 방문하지 않았고, 나보다 큰 경우
					q.add(i);
					visited[i] = true;
					tCnt++;
				}
			}
		}
	} // end of findTall
	
	/** 나보다 작은 사람 찾기 */
	private static void findSmall(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][current] == 1) { // 방문하지 않았고, 나보다 작 경우
					q.add(i);
					visited[i] = true;
					sCnt++;
				}
			}
		}
	}
	// end of findSmall

} // end of class
