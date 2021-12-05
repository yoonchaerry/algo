package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥 {

	static int N,d,k,c, arr[], visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 초밥 벨트 접시 수, 2≤N≤3,000,000
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수, 2≤d≤3,000
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수, 2≤k≤3,000 (k≤N)
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 1≤c≤d
		
		visited = new int[d+1]; // 방문배열
		arr     =  new int[N];  // 초밥 접시 수
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // end of input
		
		eat();
	} // end of main
	
	private static void eat() {
		int total = 0, max = 0;
		
		// 4접시 먹은거 초기화
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
			if(max <= total) { // 최대랑 비교
				// 쿠폰 초밥 안먹었으면 +1
				if(visited[c] == 0) max = total+1;
				else max = total;
			}
			
			// 맨 왼쪽에서 먹은거 빼기
			visited[arr[i-1]]--;
			// 전체 먹은 개수 빼기
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
