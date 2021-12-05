package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_SWEA_2239_스토쿠 {

	
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		map = new int[9][9]; // 스토쿠 생성
		for (int i = 0; i < 9; i++) { // 행
			String s = br.readLine();
			for (int j = 0; j < 9; j++) { // 열
				map[i][j] = s.charAt(j)-'0';
			}
		} // end of for input
		
		fill(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	} // end of main
	
	/** 숫자를 채워보자 - dfs*/
	private static void fill(int idx) {
		if(idx == 81) {
			flag = true;
			return;
		}
		
		int r = idx / 9;
		int c = idx % 9;
		
		if(map[r][c] != 0) { // 이미 숫자가 있는 경우
			fill(idx+1);
		}
		else { // 숫자를 채워야되는 경우
			for (int i = 1; i <= 9; i++) { // 1~9까지 탐색
				if(!isValid(r, c, i)) continue;
				
				map[r][c] = i;
				fill(idx + 1);
				if(flag) return;
				map[r][c] = 0;
			}
		}
	} // end of fill
	
	/**숫자가 들어갈 수 있는지 확인*/
	private static boolean isValid(int r, int c, int n) { // 행, 열, 숫자
		for (int i = 0; i < 9; i++) {
			if(map[r][i] == n || map[i][c] == n) return false; // 이미 해당 숫자가 존재
		}
		
		int nr = r / 3 * 3;
		int nc = c / 3 * 3;
		
		System.out.println(nr+","+nc);
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == n) return false;
			}
		}
		
		return true;
	} // end of isValid

} // end of class


