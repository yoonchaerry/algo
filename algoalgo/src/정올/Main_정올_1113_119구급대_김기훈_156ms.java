package 정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_정올_1113_119구급대_김기훈_156ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//bfs
		//진행방향이 바뀔때마다 cnt++
		//현재 좌표가 m,n일 때 cnt값으로 minCnt 갱신
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		q.offer(new int[] {0, 0, -1, 0}); //r, c, 진행방향, 코너 돈 횟수
		visited[0][0] = true;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int minCnt = Integer.MAX_VALUE;
		while(q.size() > 0) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int dir = cur[2];
			int cnt = cur[3];

			if(r == m && c == n) {
				if(minCnt > cnt)
					minCnt = cnt - 1; //맨처음 진행방향이 -1에서 바뀌었을 때 하나 빼줌
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					if(dir != d) //코너를 돌게 되면
						q.offer(new int[] {nr, nc, d, cnt+1});
					else
						q.offer(new int[] {nr, nc, d, cnt});
				}
			}
		}
		
		System.out.println(minCnt);
	}

}