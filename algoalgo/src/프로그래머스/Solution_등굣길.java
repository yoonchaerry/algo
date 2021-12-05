package ���α׷��ӽ�;

/**
 * ���α׷��ӽ� ���
 * @author leech
 * dp
 * �־��� ũ�⺸�� +2, +1 �ؼ� �����ߴµ� �ڲ� Ʋ��..��
 */
public class Solution_��� {

	public static void main(String[] args) {
		Solution_��� s = new Solution_���();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		s.solution(m, n, puddles);
	}

	public int solution(int m, int n, int[][] puddles) {        
        int[][] dp  = new int[n+1][m+1];
        
        for (int i = 0; i < puddles.length; i++) { //��ֹ� ǥ��
        	dp[puddles[i][0]][puddles[i][1]] = -1;
		}
        /*
        for (int i = 1; i <= n; i++) { //��
			for (int j = 1; j <= m; j++) { //��
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
        */
        dp[1][1] = 1; //��
        for (int i = 1; i <= n; i++) { //��
			for (int j = 1; j <= m; j++) { //��
				if(dp[i][j] == -1) continue; // ��������
								
				if(dp[i-1][j] > 0) { //����
					dp[i][j] += dp[i-1][j]%1000000007;
				}
				
				if(dp[i][j-1] > 0) { //����
					dp[i][j] += dp[i][j-1]%1000000007;
				}
			}
		}
        
        System.out.println(dp[n][m]);
        
        return dp[n][m]%1000000007;
    }

}
