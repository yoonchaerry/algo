package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_SWEA_2239_������ {

	
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		map = new int[9][9]; // ������ ����
		for (int i = 0; i < 9; i++) { // ��
			String s = br.readLine();
			for (int j = 0; j < 9; j++) { // ��
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
	
	/** ���ڸ� ä������ - dfs*/
	private static void fill(int idx) {
		if(idx == 81) {
			flag = true;
			return;
		}
		
		int r = idx / 9;
		int c = idx % 9;
		
		if(map[r][c] != 0) { // �̹� ���ڰ� �ִ� ���
			fill(idx+1);
		}
		else { // ���ڸ� ä���ߵǴ� ���
			for (int i = 1; i <= 9; i++) { // 1~9���� Ž��
				if(!isValid(r, c, i)) continue;
				
				map[r][c] = i;
				fill(idx + 1);
				if(flag) return;
				map[r][c] = 0;
			}
		}
	} // end of fill
	
	/**���ڰ� �� �� �ִ��� Ȯ��*/
	private static boolean isValid(int r, int c, int n) { // ��, ��, ����
		for (int i = 0; i < 9; i++) {
			if(map[r][i] == n || map[i][c] == n) return false; // �̹� �ش� ���ڰ� ����
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


