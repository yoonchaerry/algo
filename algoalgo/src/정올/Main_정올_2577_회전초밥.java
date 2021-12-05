package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2577_ȸ���ʹ� {

	static int N,d,k,c, arr[], visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // �ʹ� ��Ʈ ���� ��, 2��N��3,000,000
		d = Integer.parseInt(st.nextToken()); // �ʹ� ������, 2��d��3,000
		k = Integer.parseInt(st.nextToken()); // �����ؼ� �Դ� ���� ��, 2��k��3,000 (k��N)
		c = Integer.parseInt(st.nextToken()); // ���� ��ȣ 1��c��d
		
		visited = new int[d+1]; // �湮�迭
		arr     =  new int[N];  // �ʹ� ���� ��
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // end of input
		
		eat();
	} // end of main
	
	private static void eat() {
		int total = 0, max = 0;
		
		// 4���� ������ �ʱ�ȭ
		for (int i = 0; i < k; i++) {
			if(visited[arr[i]] == 0) total++;
			visited[arr[i]]++;
		}
		
//		for (int i = 0; i < d+1; i++) {
//			System.err.print(visited[i] + " ");
//		}
//		System.out.println();
//		System.out.println("total : " + total);
		
		max = total; //k-1
		for (int i = 1; i <= N; i++) {
			if(max <= total) { // �ִ�� ��
				// ���� �ʹ� �ȸԾ����� +1
				if(visited[c] == 0) max = total+1;
				else max = total;
			}
			
			// �� ���ʿ��� ������ ����
			visited[arr[i-1]]--;
			// ��ü ���� ���� ����
			if(visited[arr[i-1]] == 0) total--;
			
			if(visited[arr[(i+k-1)%N]] == 0) total++;
			visited[arr[(i+k-1)%N]]++;
		}
		
//		for (int i = 0; i < d+1; i++) {
//			System.err.print(visited[i] + " ");
//		}
//		System.out.println();
		
		System.out.println(max);
	}

} // end of class
