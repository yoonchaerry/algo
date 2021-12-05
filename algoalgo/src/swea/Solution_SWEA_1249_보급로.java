package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution_SWEA_1249_���޷�
 * @author ��ä��
 * bfs: �޸� �ʰ�
 */
public class Solution_SWEA_1249_���޷� {
	private static int N;
	private static int[][] map, dp;
	private static boolean[][] visited;
	private static final int MAX = Integer.MAX_VALUE;

	//��������� ���������� ���� ��� �߿� ���� �۾��� ��� �ð��� ���� ���� ����� ���� �ð��� ���
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽�
		for (int testCase = 1; testCase <= T; testCase++) {
			N   = Integer.parseInt(br.readLine()); // �迭�� ũ��
			map = new int[N][N];
			dp  = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
					dp[i][j]  = MAX; // ���� ū ���� �������ֱ�
				}
			} // end of for:input
			/* debug
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			*/
			
			min = MAX;
			visited = new boolean[N][N];
			dp[0][0] = map[0][0];
			go();
			
			//System.out.println(min);
			sb.append("#").append(testCase).append(" ").append(min).append("\n"); //���
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	static int[] dr = {-1,1,0,0}; //�Ͽ�
	static int[] dc = {0,0,-1,1};
	static int min;
 	/** bfs */
	private static void go() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[]{0,0}); // ������
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll(); // ������
			int r = current[0];
			int c = current[1];
			
			if(r==N-1 && c ==N-1) { // �������� ������ ��� �ּڰ� ��
				min = Math.min(min, dp[N-1][N-1]);
			}
			
			if(min <= dp[r][c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>= N || nc<0 || nc>=N) continue; // ������ ��� ���
				
				if(!visited[nr][nr] || dp[nr][nc] > dp[r][c] + map[nr][nc]) { // �湮���� ���� ��� �̵�
					visited[nr][nc] = true;
					dp[nr][nc] = dp[r][c] + map[nr][nc]; // �ɸ��� �ð� �����ֱ�
				
					q.add(new int[] {nr,nc});
				}
			} // end of for:4��
		}
	}
	
} // end of class
