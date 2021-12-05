package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_5643_Ű����
 * @author ��ä��
 * bfs..
 */
public class Solution_SWEA_5643_Ű���� {

	private static int N, M, tCnt, sCnt;
	private static int[][] adj;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 1 �� T �� 15
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine()); // �л��� ��, 2 �� N �� 500
			M = Integer.parseInt(br.readLine()); // �� Ƚ��, 0 �� M �� N*(N-1)/2
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
				tCnt = 0; // �ڱ⺸�� ū
				sCnt = 0; // �ڱ⺸�� ����
				
				findTall(i);
				findSmall(i);
				
				// ū + ���� = ���л� - 1 �̸� ���� �� �� ����
				if(tCnt+sCnt == N-1) answer++;
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");			
			
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	/** ������ ū ��� ã�� */
	private static void findTall(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[current][i] == 1) { // �湮���� �ʾҰ�, ������ ū ���
					q.add(i);
					visited[i] = true;
					tCnt++;
				}
			}
		}
	} // end of findTall
	
	/** ������ ���� ��� ã�� */
	private static void findSmall(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][current] == 1) { // �湮���� �ʾҰ�, ������ �� ���
					q.add(i);
					visited[i] = true;
					sCnt++;
				}
			}
		}
	}
	// end of findSmall

} // end of class
