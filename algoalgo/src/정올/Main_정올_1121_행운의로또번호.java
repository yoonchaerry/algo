package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * Main_정올_1121_행운의로또번호
 * @author leech
 * dfs 시간초과
 * 답은 dp...
 */
public class Main_정올_1121_행운의로또번호 {

	static int M,N;
	public static void main(String[] args) throws Exception {
		System.out.println(System.currentTimeMillis());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 1≤N≤10
			M = Integer.parseInt(st.nextToken()); // 1≤M≤2,000
			
			if(M==0 && N==0) { // 입력 종료
				bw.write(sb.toString());
				bw.flush();
				bw.close();
				System.err.println(System.currentTimeMillis());
				return;
			}
			
			answer = 0;	
			if(N==1) {
				answer = M;
			}
			else {
				for (int i = 1; i <= M/N; i++) {
					select(i,1);
				}				
			}
			
			sb.append(answer).append("\n");
		} // end of while : input
		
	} // end of main

	/** 뽑기 */
	static int answer;
	private static void select(int start, int cnt) {
		if(!check(start, cnt)) {
			return;
		}
		
		if(cnt == N-1) { // 모두 뽑은 경우
			int left = M-(start*2)+1;
			if(left > 0) {
				answer += left;
				return;				
			}
		}
		
		//그 숫자가 앞의 수보다 2배 이상 큰 숫자라는 것
		for (int i = start*2; i <= M; i++) {
			select(i, cnt+1);
		}
	}// end of select	
	
	/**가능한지 여부 체크*/
	private static boolean check(int start, int cnt) {
		int check = start  * (int)Math.pow(2, N-cnt);
		if(check <= M) return true;
		return false;
	}
} // end of class
