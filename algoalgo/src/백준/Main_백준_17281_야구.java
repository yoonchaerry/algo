package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_17281_야구
 * @author leech
 */
public class Main_백준_17281_야구 {
	
	static int N, answer;
	static int[][] map;
	static int[] players;     // 선수 순서
	static boolean[] selected; // 방문 배열

	// 아웃0, 안타1, 2루타2, 3루타3, 홈런4
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine()); // 이닝 수
		map = new int[N+1][10];
		for (int i = 1; i <= N; i++) { // 각 이닝 입력 값 받기
			String input = br.readLine();
			for (int j = 0, idx=0; j < 9; j++, idx=+2) {
				map[i][j] = input.charAt(idx) - '0';
			}
		}
		
		players = new int[10]; // 선수 순서
		selected = new boolean[10]; // 방문 배열

		players[4] = 1; //자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 
		selected[4] = true;
		
		perm(2); // 고정 선수는 정했으므로
	
		System.out.println(answer);
	}
	
	/* 순열 선수 순서 정하기 */
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
		boolean[] base; // 홈, 1루, 2루, 3루
		
		for (int i = 1; i <= N; i++) {
			int out = 0;
			base = new boolean[4];
			
			outer : while(true) {
				for (int num = 1; num <= 9; num++) { // 선수 번호
					int play = map[i][players[num]];
					
					switch(play) {
					case 0: // 아웃
						out++;
						break;
					case 1: // 안타
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // 베이스 움직이기
							if(base[baseNum]) {
								if(baseNum == 3) { // 3루에 있는경우
									score++;
									base[baseNum] = false;
									continue;
								}
								// 1,2루에 있는 경우
								base[baseNum] = false;
								base[baseNum + 1] = true;
							}
						}
						base[1] = true; // 진루
						break;
					case 2: // 2루타
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // 베이스 움직이기
							if(base[baseNum]) {
								if(baseNum == 3 || baseNum == 2) { // 3,2루에 있는경우
									score++;
									base[baseNum] = false;
									continue;
								}
								// 1에 있는 경우
								base[baseNum] = false;
								base[baseNum + 2] = true;
							}
						}
						
						base[2] = true; // 진루
						break;
					case 3: // 3루타
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // 베이스 움직이기
							if(base[baseNum]) { // 1,2,3 루 다 홈으로
								score++;
								base[baseNum] = false;
							}
						}
						base[3] = true; // 진루
						break;
					case 4: // 홈런
						for (int baseNum = 3; baseNum >= 1; baseNum--) { // 베이스 움직이기
							if(base[baseNum]) { // 1,2,3 루 다 홈으로
								score++;
								base[baseNum] = false;
							}
						}
						
						score++; // 홈런타자 홈으로
						break;
					} // end of switch
					
					if(out == 3) {
						initPlayer = num + 1;
						
						if(initPlayer == 10) initPlayer = 1;
						
						break outer;
					}
				} // end of for : 선수
				
				initPlayer = 1;
			}// end of while
		}
		
		answer = Math.max(answer, score);
 	} // end of playBall
}
