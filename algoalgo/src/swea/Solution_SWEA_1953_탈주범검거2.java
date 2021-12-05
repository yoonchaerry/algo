package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Solution_SWEA_1953_Ż�ֹ��˰�
 * @author ��ä��
 * �غ��ڰ�!
 */
public class Solution_SWEA_1953_Ż�ֹ��˰�2 {
	
	private static int[] dr = {-1,0,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			
			sb.append("#").append(testCase).append(" ").append("find").append("\n");
		} // end of for:testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main
	
	
} // end of class
