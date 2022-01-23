package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ����_17136_�����̺��̱�
 * @author chaerry
 * �������� ũ��� 1��1, 2��2, 3��3, 4��4, 5��5�� �� �ټ� ������ ������, �� ������ �����̴� 5����
 * �����̸� ũ�Ⱑ 10��10�� ���� ���� ���̷��� �Ѵ�. ���̴� 1��1 ũ���� ĭ���� �������� ������, ������ ĭ���� 0 �Ǵ� 1�� ���� �ִ�.
 * 1�� ���� ĭ�� ��� �����̷� �������� �Ѵ�. �����̴� ���簢��, �ʿ��� �ּ��� ������ �� ���ϱ�
 */
public class Main_����_17136_�����̺��̱� {
	static int SIZE   = 10; // 10��10�� ����
	static int answer = Integer.MAX_VALUE;
	static int[]   map_count = {0, 5, 5, 5, 5, 5}; // ������ ��
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) { // ��
			String input = br.readLine();
			for (int j = 0, idx = 0; j < SIZE; j++, idx+=2) { // ��
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
	    // ��
		if(r==9 && c==9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// cnt�� answer���� �۰ų� ū ��� �Ѿ��
		if(cnt >= answer) return;
		
		// ������ ĭ�� �Ѿ ��� �� �̵�
		if(c > 9) {
			DFS(r+1, 0, cnt);
			return;
		}
		
		if(map[r][c] == 1) {
			for (int size = 5; size > 0; size--) { // i = ������ ũ��
				// �����̰� ���� �ִ���, �����ȿ� �ִ��� üũ
				if(map_count[size]>0 && isPossble(r,c,size)) {
					// ������ ���̱�
					for (int i = r; i < r+size; i++) {
						for (int j = c; j < c+size; j++) {
							map[i][j] = 0;
						}
					}
					
					// ������ ���� ����
					map_count[size]--;
					
					// ĭ �̵��ؼ� ���̱�
					DFS(r, c+1, cnt+1);
					
					// ������ ����
					for (int i = r; i < r+size; i++) {
						for (int j = c; j < c+size; j++) {
							map[i][j] = 1;
						}
					}
					
					// ������ ���� �ø���
					map_count[size]++;
				}
			}
		}
		else {
			// ĭ �̵�
			DFS(r, c+1, cnt);
		}
	}
	
	/**
	 * �����̸� ���� �� �ִ��� Ȯ��
	 * (r ��ǥ, c ��ǥ, size ������ ũ��)
	 */
	public static boolean isPossble(int r, int c, int size) {
		for (int nr = r; nr < r+size; nr++) {
			for (int nc = c; nc < c+size; nc++) {
				// �����ȿ� �ְ� �����̸� ���� �� �ִ��� üũ
				// �ϳ��� �ƴ϶�� false
				if((nr<0 || nr>=SIZE || nc<0 || nc>=SIZE) || map[nr][nc] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
