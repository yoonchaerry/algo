package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정올_1515_구슬찾기
 * @author leech
 * 플로이드와샬
 */
public class Main_정올_1515_구슬찾기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 구슬의 개수, 1≤N≤99
		int M = Integer.parseInt(st.nextToken()); // 쌍의 수
		int half = N/2; 
		int[][] beads = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			beads[a][b] = 1; // a>b
			beads[b][a] = -1;  // b<a
			
		} // end of input
		
		//나보다 크거나, 작은 구슬의 수가 절반보다 많으면 답 ++
		for (int i = 1; i <= N; i++) { // 중간
			for (int s = 1; s <= N; s++) { // 출발
				for (int e = 1; e <= N; e++) { // 도착
					// 구슬이 관계가 있는경우 중간 관계가 있으면 만들어 주기
					// 출발(s)->중간(i)  == 중간(i)->도착(e) ->
					if(beads[e][i] != 0 && beads[s][i] == beads[i][e]) {
						beads[s][e] = beads[s][i]; // 무게 비교 추가
					}
				}
			}
		}

		int[] heavy = new int[N+1];
		int[] light = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 무거운 구슬인 경우 
				if(beads[i][j] == 1) heavy[i]++;
				// 가벼운 구슬인 경우 
				if(beads[i][j] == -1) light[i]++;
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			// 절반보다 많으면 답의 개수를 늘려준다
			if(heavy[i] > half) answer++;
			if(light[i] > half) answer++;
		}
		
		System.out.println(answer);
	} // end of main

} // end of class
