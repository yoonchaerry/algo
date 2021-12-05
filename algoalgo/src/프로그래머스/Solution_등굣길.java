package 프로그래머스;

/**
 * 프로그래머스 등굣길
 * @author leech
 * dp
 * 주어진 크기보다 +2, +1 해서 제출했는데 자꾸 틀림..ㅎ
 */
public class Solution_등굣길 {

	public static void main(String[] args) {
		Solution_등굣길 s = new Solution_등굣길();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		s.solution(m, n, puddles);
	}

	public int solution(int m, int n, int[][] puddles) {        
        int[][] dp  = new int[n+1][m+1];
        
        for (int i = 0; i < puddles.length; i++) { //장애물 표시
        	dp[puddles[i][0]][puddles[i][1]] = -1;
		}
        /*
        for (int i = 1; i <= n; i++) { //행
			for (int j = 1; j <= m; j++) { //열
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
        */
        dp[1][1] = 1; //집
        for (int i = 1; i <= n; i++) { //행
			for (int j = 1; j <= m; j++) { //열
				if(dp[i][j] == -1) continue; // 물웅덩이
								
				if(dp[i-1][j] > 0) { //위쪽
					dp[i][j] += dp[i-1][j]%1000000007;
				}
				
				if(dp[i][j-1] > 0) { //왼쪽
					dp[i][j] += dp[i][j-1]%1000000007;
				}
			}
		}
        
        System.out.println(dp[n][m]);
        
        return dp[n][m]%1000000007;
    }

}
