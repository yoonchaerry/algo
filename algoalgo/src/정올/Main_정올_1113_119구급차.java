package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_정올_1113_119구급차 {

	static int M, N, m, n, map[][];
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1}; // 상하좌우
	static int min = Integer.MAX_VALUE; // 최솟값
	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로, M(1≤M≤100)
		N = Integer.parseInt(st.nextToken()); // 세로, N(1≤N≤100)
		
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken()); // 도착지 좌표
		n = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 1은 도로이고 0은 진입할 수 없는
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[M][N];
		//dfs(0, 0, 0, -1);
		bfs();
		
		System.out.println(min);
		
	} // end of main
	
	/**bfs*/
	private static void bfs() {
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
				
			}
		});
		
		q.add(new int[] {0,0,0,-1}); //좌표, 방향전환 횟수, 방향
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			int cnt = current[2];
			int dir = current[3];
			
			//System.out.println("("+r+","+c+") " + cnt+", "+dir);
			if(r==m && c==n) { // 종료 조건
				min = Math.min(min, cnt);
				break;
			}
			
			
			for (int d = 0; d < 4; d++) { // 4방탐색
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) { // 범위안에 있고, 도로인 경우
					if(dir==-1 || dir==d && (nr != r || nc != c)) {
						q.add(new int[] {nr,nc,cnt,d});
					}
					else {
						q.add(new int[] {nr,nc,cnt+1,d}); // 방향이 바뀌었으니까 +1
					}					
					
					visited[nr][nc] = true;
				}
			}
		}
	} // end of bfs

	/** dfs */
	private static void dfs(int r, int c, int cnt, int dir) { // 좌표, 방향전환 횟수, 방향
		//System.out.println("("+r+","+c+") " + cnt+", "+dir);
		visited[r][c] = true; // 방문체크
		
		if(r==m && c==n) { // 종료 조건
			min = Math.min(min, cnt);
			return;
		}
				
		for (int d = 0; d < 4; d++) { // 4방탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) { // 범위안에 있고, 도로인 경우
				if(dir==-1 || dir==d) {
					dfs(nr, nc, cnt, d);
				}
				else {
					dfs(nr, nc, cnt+1, d); // 방향이 바뀌었으니까 +1
				}
				
				visited[nr][nc] = false;
			}
		}
	} // end of dfs

} // end of class
