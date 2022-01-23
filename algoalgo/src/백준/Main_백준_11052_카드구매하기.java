package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11052_카드구매하기 {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 구매하려는 카드 갯수
		int[] cards = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i] = dp[i-j] + cards[j] 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+cards[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
