package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // testCase
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 구슬 쏠 횟수, 1 ≤ N ≤ 4
			int W = Integer.parseInt(st.nextToken()); // 열 너비, 2 ≤ W ≤ 12
			int H = Integer.parseInt(st.nextToken()); // 행 높이, 2 ≤ H ≤ 15
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) { // 행
				String input = br.readLine();
				for (int j = 0, idx = 0; j < W; j++, idx+=2) { //열
					map[i][j] = input.charAt(idx)-'0';
				}
			} // end of input
			
//			for (int i = 0; i < H; i++) {
//				for (int j = 0; j < W; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			// 벽돌 깨기 : 남은 벽돌의 수 구하기
			
		} // end of for:testcase
	} // end of main
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	/** bfs */
	private static void breakBrick(int r) {
		
	}

} // end of class
 