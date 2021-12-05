package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution_SWEA_1767_프로세서연결 {
	private static int N, coreCnt, maxCore, minWire;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<int[]> cores; // 코어리스트
	private static int[] dr = {-1,1,0,0}; // 상하좌우
	private static int[] dc = {0,0,-1,1}; // 상하좌우

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine()); // 7 ≤  N ≤ 12
			map = new int[N][N];
			cores = new ArrayList<int[]>();
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx+=2) {
					map[i][j] = s.charAt(idx)-'0';
					
					if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1) continue; // 가장자리 코어는 패스
					// 코어 위치 리스트에 추가
					if (map[i][j] == 1) {
						cores.add(new int[] { i, j });
						coreCnt++;
					}
				}
			} // input
			
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			
			dfs(0,0,0); // 코어 인덱스, 코어수, 전선수
			
			sb.append("#").append(testCase).append(" ").append(minWire).append("\n");
		} // testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	/** 전선 연결하기 */
	private static void dfs(int idx, int core, int wire) {
		if(idx == cores.size()) { // 종료조건
			if(maxCore < core) {
				maxCore = core;
				minWire = wire;
			}
			else if(maxCore ==  core) {
				minWire = Math.min(wire, minWire);
			}			
			return;
		}
		
		// 코어 위치
		int r = cores.get(idx)[0];
		int c = cores.get(idx)[1];		
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int count = 0;
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[i];
				nc += dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) break; //범위 체크
				
				//가는길에 전선이 있거나 코어가 존재하는지 확인
				if(map[nr][nc] == 1) {
					count = 0;
					break;
				}
				
				count++;
			} // end of while
			
			// count 만큼 전선 채우기
			int wr = r;
			int wc = c;
			for (int j = 0; j < count; j++) {
				wr += dr[i];
				wc += dc[i];
				map[wr][wc] = 1;
			}
			
			// count == 0 전선을 연결할 수 없음
			if(count==0) dfs(idx+1, core, wire);
			else {
				dfs(idx+1, core+1, wire+count);
				
				//전선 없애기
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
