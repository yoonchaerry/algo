package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * Main_정올_1121_행운의로또번호
 * @author leech
 * 
 */
public class Main_정올_1121_행운의로또번호2 {

	static int M,N;
	public static void main(String[] args) throws Exception {
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

	/** bfs */
	static int answer;
	private static void select(int start, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {start, cnt});
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int num = current[0] * 2;
			int count = current[1];
			
			for (int i = num; i <= M; i++) {
				
			}
			
		}
	}// end of select	

} // end of class
