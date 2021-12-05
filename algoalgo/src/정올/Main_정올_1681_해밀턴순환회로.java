package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로 {
	
	private static int N, min;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 장소 수, 1≤N≤12
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
		visited = new boolean[N]; // 방문배열
		min 	= Integer.MAX_VALUE;
		dfs(0,0,0);
		
		System.out.println(min);
	} // end of main
	
	private static void dfs(int idx, int cnt, int sum) {
		if(cnt == N-1) { // 종료 조건
			if(map[idx][0] == 0) return;
			sum += map[idx][0];
			
			min = Math.min(sum, min);
		}
		
		if(sum > min) return; // 최솟값보다 큰 경우 리턴
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] && map[idx][i] > 0) { // 방문안했고, 갈 수 있는 경우
				visited[i] = true;
				dfs(i, cnt+1, sum+map[idx][i]);
				visited[i] = false;				
			}
		}
	}

} // end of class
