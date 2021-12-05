package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1. 비가장자리 코어를 리스트에 담기
//2. 코어 리스트로 부분집합 처리하여 시도해볼 코어 선택
//3. 선택된 코어마다 4방향 전선 놓기 시도
// 전선방향으로 놓을수 있는지 체크 (가능:전선놓기->마킹/불가능:다음)
public class Solution_SWEA_1767_프로세서연결2 {
	private static int N, map[][], max, min, totalCnt; // max:최대코어, min:최소전선
	private static boolean[][] visited;
	private static ArrayList<int[]> list; // 코어리스트(가장자리가 아닌 코어)
	private static int[] dr = {-1,1,0,0}; // 상하좌우
	private static int[] dc = {0,0,-1,1}; // 상하좌우

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N    = Integer.parseInt(br.readLine()); // 7 ≤  N ≤ 12
			map  = new int[N][N];
			list = new ArrayList<int[]>();
			max  = 0;
			min  = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리 코어는 저장X
					if(i==0 || i==N-1 || j==0 || j==N-1) continue;
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++; // 가장자리가 아닌 코어 수
					}
				}
			}
			
			go(0,0);
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		} // testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	private static void go(int index, int cCnt) {
		if(index == totalCnt) { // 종료조건
			int res = getLength();
			// 선택된 코어 개수로 max 갱신
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}
			else if(max == cCnt) { // 코어개수가 같으면 최소전선길이의 합
				if(min > res) min = res;
			}
			
			return;
		}
		
		int[] current = list.get(index);
		int r = current[0];
		int c = current[1];
		
		// index core 선택 : 4방향 시도
		for (int d = 0; d < 4; d++) { // 현재 코어에서 전선 상하좌우
			if(isAvailable(r,c,d)) {
				// 전선 놓기
				setStatus(r,c,d,2);
				// 다음 코어로
				go(index+1, cCnt+1);
				// 놓았던 전선 지우기
				setStatus(r,c,d,0);
			}
		}
		
		// index core 미선택
		go(index+1, cCnt);
	}

	private static int getLength() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) res++;
			}
		}
		return res;
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			
			map[nr][nc] = s;
			
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			if(map[nr][nc] >= 1) return false; // 코어나 전선이 있는경우
		}
		return true;
	}

} // end of class
