package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_����_17281_�߱�
 * @author leech
 */
public class Main_����_17281_�߱� {
	
	static int N, answer;
	static int[][] map;
	static int[] players;     // ���� ����
	static boolean[] selected; // �湮 �迭

	// �ƿ�0, ��Ÿ1, 2��Ÿ2, 3��Ÿ3, Ȩ��4
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine()); // �̴� ��
		map = new int[N+1][10];
		for (int i = 1; i <= N; i++) { // �� �̴� �Է� �� �ޱ�
			String input = br.readLine();
			for (int j = 0, idx=0; j < 9; j++, idx=+2) {
				map[i][j] = input.charAt(idx) - '0';
			}
		}
		
		players = new int[10]; // ���� ����
		selected = new boolean[10]; // �湮 �迭

		players[4] = 1; //�ڽ��� ���� �����ϴ� ������ 1�� ������ 4�� Ÿ�ڷ� �̸� �����ߴ�. 
		selected[4] = true;
		
		perm(2); // ���� ������ �������Ƿ�
	
		System.out.println(answer);
	}
	
	/* ���� ���� ���� ���ϱ� */
	public static void perm(int num) {
		if(num == 10) {
			playBall();
		}
		
		for (int i = 1; i <= 9; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			players[i] = num;
			perm(num + 1);
			selected[i] = false;
		}
	}
	
	public static void playBall() {
		int score = 0;
		int initPlayer = 1;
		boolean[] base; // Ȩ, 1��, 2��, 3��
		
		for (int i = 1; i <= N; i++) {
			int out = 0;
			base = new boolean[4];
			
			outer : while(true) {
				for (int num = 1; num <= 9; num++) { // ���� ��ȣ
					int play = map[i][players[num]];
					
					switch(play) {
					case 0: // �ƿ�
						out++;
						break;
					case 1: // ��Ÿ
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // ���̽� �����̱�
							if(base[baseNum]) {
								if(baseNum == 3) { // 3�翡 �ִ°��
									score++;
									base[baseNum] = false;
									continue;
								}
								// 1,2�翡 �ִ� ���
								base[baseNum] = false;
								base[baseNum + 1] = true;
							}
						}
						base[1] = true; // ����
						break;
					case 2: // 2��Ÿ
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // ���̽� �����̱�
							if(base[baseNum]) {
								if(baseNum == 3 || baseNum == 2) { // 3,2�翡 �ִ°��
									score++;
									base[baseNum] = false;
									continue;
								}
								// 1�� �ִ� ���
								base[baseNum] = false;
								base[baseNum + 2] = true;
							}
						}
						
						base[2] = true; // ����
						break;
					case 3: // 3��Ÿ
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // ���̽� �����̱�
							if(base[baseNum]) { // 1,2,3 �� �� Ȩ����
								score++;
								base[baseNum] = false;
							}
						}
						base[3] = true; // ����
						break;
					case 4: // Ȩ��
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // ���̽� �����̱�
							if(base[baseNum]) { // 1,2,3 �� �� Ȩ����
								score++;
								base[baseNum] = false;
							}
						}
						
						score++; // Ȩ��Ÿ�� Ȩ����
						break;
					} // end of switch
					
					if(out == 3) {
						initPlayer = num + 1;
						
						if(initPlayer == 10) initPlayer = 1;
						
						break outer;
					}
				} // end of for : ����
				
				initPlayer = 1;
			}// end of while
		}
		
		answer = Math.max(answer, score);
 	} // end of playBall
}
