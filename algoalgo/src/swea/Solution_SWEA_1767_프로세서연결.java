package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution_SWEA_1767_���μ������� {
	private static int N, coreCnt, maxCore, minWire;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<int[]> cores; // �ھ��Ʈ
	private static int[] dr = {-1,1,0,0}; // �����¿�
	private static int[] dc = {0,0,-1,1}; // �����¿�

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine()); // 7 ��  N �� 12
			map = new int[N][N];
			cores = new ArrayList<int[]>();
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx+=2) {
					map[i][j] = s.charAt(idx)-'0';
					
					if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1) continue; // �����ڸ� �ھ�� �н�
					// �ھ� ��ġ ����Ʈ�� �߰�
					if (map[i][j] == 1) {
						cores.add(new int[] { i, j });
						coreCnt++;
					}
				}
			} // input
			
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			
			dfs(0,0,0); // �ھ� �ε���, �ھ��, ������
			
			sb.append("#").append(testCase).append(" ").append(minWire).append("\n");
		} // testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	/** ���� �����ϱ� */
	private static void dfs(int idx, int core, int wire) {
		if(idx == cores.size()) { // ��������
			if(maxCore < core) {
				maxCore = core;
				minWire = wire;
			}
			else if(maxCore ==  core) {
				minWire = Math.min(wire, minWire);
			}			
			return;
		}
		
		// �ھ� ��ġ
		int r = cores.get(idx)[0];
		int c = cores.get(idx)[1];		
		for (int i = 0; i < 4; i++) { // 4�� Ž��
			int count = 0;
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[i];
				nc += dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) break; //���� üũ
				
				//���±濡 ������ �ְų� �ھ �����ϴ��� Ȯ��
				if(map[nr][nc] == 1) {
					count = 0;
					break;
				}
				
				count++;
			} // end of while
			
			// count ��ŭ ���� ä���
			int wr = r;
			int wc = c;
			for (int j = 0; j < count; j++) {
				wr += dr[i];
				wc += dc[i];
				map[wr][wc] = 1;
			}
			
			// count == 0 ������ ������ �� ����
			if(count==0) dfs(idx+1, core, wire);
			else {
				dfs(idx+1, core+1, wire+count);
				
				//���� ���ֱ�
				wr = r;
				wc = c;
				for (int j = 0; j < count; j++) {
					wr += dr[i];
					wc += dc[i];
					map[wr][wc] = 0;
				}
			}
		}
	}
} // end of class
