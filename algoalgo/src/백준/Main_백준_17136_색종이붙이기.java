package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준_17136_색종이붙이기
 * @author chaerry
 * 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩
 * 색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다.
 * 1이 적힌 칸은 모두 색종이로 덮여져야 한다. 색종이는 정사각형, 필요한 최소의 색종이 수 구하기
 */
public class Main_백준_17136_색종이붙이기 {
	static int SIZE   = 10; // 10×10인 종이
	static int answer = Integer.MAX_VALUE;
	static int[]   map_count = {0, 5, 5, 5, 5, 5}; // 색종이 수
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) { // 행
			String input = br.readLine();
			for (int j = 0, idx = 0; j < SIZE; j++, idx+=2) { // 열
				int num = input.charAt(idx) - '0';
				map[i][j] = num;
			}
		}
		
		DFS(0, 0, 0);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
	
	public static void DFS(int r, int c, int cnt) {
	    // 끝
		if(r==9 && c==9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// cnt가 answer보다 작거나 큰 경우 넘어가기
		if(cnt >= answer) return;
		
		// 마지막 칸을 넘어간 경우 줄 이동
		if(c > 9) {
			DFS(r+1, 0, cnt);
			return;
		}
		
		if(map[r][c] == 1) {
			for (int size = 5; size > 0; size--) { // i = 색종이 크기
				// 색종이가 남아 있는지, 범위안에 있는지 체크
				if(map_count[size]>0 && isPossble(r,c,size)) {
					// 색종이 붙이기
					for (int i = r; i < r+size; i++) {
						for (int j = c; j < c+size; j++) {
							map[i][j] = 0;
						}
					}
					
					// 색종이 개수 빼기
					map_count[size]--;
					
					// 칸 이동해서 붙이기
					DFS(r, c+1, cnt+1);
					
					// 색종이 떼기
					for (int i = r; i < r+size; i++) {
						for (int j = c; j < c+size; j++) {
							map[i][j] = 1;
						}
					}
					
					// 색종이 개수 올리기
					map_count[size]++;
				}
			}
		}
		else {
			// 칸 이동
			DFS(r, c+1, cnt);
		}
	}
	
	/**
	 * 색종이를 붙일 수 있는지 확인
	 * (r 좌표, c 좌표, size 색종이 크기)
	 */
	public static boolean isPossble(int r, int c, int size) {
		for (int nr = r; nr < r+size; nr++) {
			for (int nc = c; nc < c+size; nc++) {
				// 범위안에 있고 색종이를 붙일 수 있는지 체크
				// 하나라도 아니라면 false
				if((nr<0 || nr>=SIZE || nc<0 || nc>=SIZE) || map[nr][nc] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
