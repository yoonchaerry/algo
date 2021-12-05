package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA_8458_������������
 * @author ��ä��
 */
public class Solution_SWEA_8458_������������ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //1 �� N �� 10
			int[] length = new int[N];
			
			int sum = 0; // ��
			int cnt = 0; // �̵�Ƚ��
			int max = 0; // �ִ�
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				length[i] = Math.abs(x) + Math.abs(y);
				max = Math.max(max, length[i]);
				
				if(i>0  && (length[i]%2 != length[i-1]%2)) { // ������ ¦���ų� Ȧ���ų� ���� ������ �̵� �Ұ���
					cnt = -1;
				}
			}
			
			if(cnt == 0) { // �̵������� ���
				while(true) {
					boolean flag = true;
					
					if(sum < max || (max-sum)%2 !=0) {
						flag = false;
					}
					
					if(flag) break; // max���� ũ�鼭 max���� ���̰� ¦���� �� ����
					
					sum += ++cnt;
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

} // end of class
