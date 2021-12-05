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
 * Solution_SWEA_1249_���޷�
 * @author ��ä��
 * ���ͽ�Ʈ��
 */
public class Solution_SWEA_1249_���޷�2 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static final int INF = Integer.MAX_VALUE;
	static int[] dr = {-1,1,0,0}; //�Ͽ�
	static int[] dc = {0,0,-1,1};

	//��������� ���������� ���� ��� �߿� ���� �۾��� ��� �ð��� ���� ���� ����� ���� �ð��� ���
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽�
		for (int testCase = 1; testCase <= T; testCase++) {
			N   = Integer.parseInt(br.readLine()); // �迭�� ũ��
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine(); // ��� 0~9
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			} // end of for:input			
			
			sb.append("#").append(testCase).append(" ").append(dijkstra(0,0)).append("\n"); //���
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	/**���ͽ�Ʈ��*/
	private static int dijkstra(int startR, int startC) { // ����� r,c
		boolean[][] visited = new boolean[N][N]; // �湮�迭
		int[][]  	minTime  = new int[N][N]; 	  // �ּҺ�� ����
		
		// �ּҺ���� ã�ƾ��ϴϱ� �ִ����� �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		minTime[startR][startC] = 0; // ����������� ����� 0
		
		int r = 0, c = 0, minCost = 0, nr,nc;
		while(true) {
			// step1 �����->�ڽ� ����� �ּ��� �� ����
			
			
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
			visited[r][c] = true; // �湮ó��
			if(r==N-1 && c==N-1) return minCost; // ������
			
			// step2 : step1 ���� ���õ� ������ �������� �ؼ� �������� ��������
			// �� ������ ���� 4��
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
