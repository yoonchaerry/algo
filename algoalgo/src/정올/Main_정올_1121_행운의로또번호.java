package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * Main_����_1121_����Ƿζǹ�ȣ
 * @author leech
 * dfs �ð��ʰ�
 * ���� dp...
 */
public class Main_����_1121_����Ƿζǹ�ȣ {

	static int M,N;
	public static void main(String[] args) throws Exception {
		System.out.println(System.currentTimeMillis());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 1��N��10
			M = Integer.parseInt(st.nextToken()); // 1��M��2,000
			
			if(M==0 && N==0) { // �Է� ����
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

	/** �̱� */
	static int answer;
	private static void select(int start, int cnt) {
		if(!check(start, cnt)) {
			return;
		}
		
		if(cnt == N-1) { // ��� ���� ���
			int left = M-(start*2)+1;
			if(left > 0) {
				answer += left;
				return;				
			}
		}
		
		//�� ���ڰ� ���� ������ 2�� �̻� ū ���ڶ�� ��
		for (int i = start*2; i <= M; i++) {
			select(i, cnt+1);
		}
	}// end of select	
	
	/**�������� ���� üũ*/
	private static boolean check(int start, int cnt) {
		int check = start  * (int)Math.pow(2, N-cnt);
		if(check <= M) return true;
		return false;
	}
} // end of class
