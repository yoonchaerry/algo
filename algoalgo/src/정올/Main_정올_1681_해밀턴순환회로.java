package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_1681_�ع��ϼ�ȯȸ�� {
	
	private static int N, min;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // ��� ��, 1��N��12
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input
		/*
		for (int i = 0; i < N; i++) {
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		*/
		visited = new boolean[N]; // �湮�迭
		min 	= Integer.MAX_VALUE;
		dfs(0,0,0);
		
		System.out.println(min);
	} // end of main
	
	private static void dfs(int idx, int cnt, int sum) {
		if(cnt == N-1) { // ���� ����
			if(map[idx][0] == 0) return;
			sum += map[idx][0];
			
			min = Math.min(sum, min);
		}
		
		if(sum > min) return; // �ּڰ����� ū ��� ����
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] && map[idx][i] > 0) { // �湮���߰�, �� �� �ִ� ���
				visited[i] = true;
				dfs(i, cnt+1, sum+map[idx][i]);
				visited[i] = false;				
			}
		}
	}

} // end of class
