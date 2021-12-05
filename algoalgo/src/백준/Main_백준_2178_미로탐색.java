package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ����_2178_�̷�Ž��
 * @author leech
 * dfs : �ð��ʰ�..��
 * bfs : 96ms
 */
public class Main_����_2178_�̷�Ž�� {

	private static int N, M;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //2 �� N, M �� 100
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j)- '0';
			}
		} // input
		
		boolean[][] visited = new boolean[N][M];
		//dfs(0,0,1,visited);
		bfs(visited);
		
		//System.out.println(min);
		System.out.println(map[N-1][M-1]);
	} // end of main
	
	static int[] dr  = {-1,1,0,0}; // �����¿�
	static int[] dc  = {0,0,-1,1}; // �����¿�
	static int   min = 987654321;
	
	/** dfs */
	private static void dfs(int r, int c, int cnt, boolean[][] visited) {
		if(r == N-1 && c == M-1) { // �������� �����ϸ�
			min = Math.min(min, cnt);
			
			return;
		}
		
		if(cnt > min) return;
		
		visited[r][c] = true; //�湮üũ
		
		//4������ �����̸鼭 1�̸鰡�� 0�̸� �н�
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 1) {
				dfs(nr, nc, cnt+1, visited);
				visited[r][c] = false; //�湮üũ ��ü
			}
			
		}
	}
	
	/** bfs */
	private static void bfs(boolean[][] visited) {
		Queue<int[]> q = new LinkedList<int[]>(); 
		q.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			//4������ �����̸鼭 1�̸鰡�� 0�̸� �н�
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || visited[nr][nc]) continue;
								
				q.offer(new int[] {nr, nc});
				map[nr][nc] = map[r][c] + 1; // �迭�ȿ� ���� �湮�� ���� ���� �湮�ߴ� ������ 1ĭ �� �����ϹǷ� +1
				visited[nr][nc] = true; // �湮üũ
			}			
		}
	}
} // end of class
