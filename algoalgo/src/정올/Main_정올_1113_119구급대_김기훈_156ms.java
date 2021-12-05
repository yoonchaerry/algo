package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_����_1113_119���޴�_�����_156ms {

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
		//��������� �ٲ𶧸��� cnt++
		//���� ��ǥ�� m,n�� �� cnt������ minCnt ����
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		q.offer(new int[] {0, 0, -1, 0}); //r, c, �������, �ڳ� �� Ƚ��
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
					minCnt = cnt - 1; //��ó�� ��������� -1���� �ٲ���� �� �ϳ� ����
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					if(dir != d) //�ڳʸ� ���� �Ǹ�
						q.offer(new int[] {nr, nc, d, cnt+1});
					else
						q.offer(new int[] {nr, nc, d, cnt});
				}
			}
		}
		
		System.out.println(minCnt);
	}

}