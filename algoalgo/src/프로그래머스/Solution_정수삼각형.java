package ���α׷��ӽ�;
/**
 * ���α׷��ӽ� �����ﰢ��
 * @author leech
 */
public class Solution_�����ﰢ�� {

	public static void main(String[] args) {
		Solution_�����ﰢ�� s = new Solution_�����ﰢ��();
		int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		s.solution(triangle);
	}

	public int solution(int[][] triangle) {
        int max = 0;
        int length = triangle.length;
        int[][] dp = new int[length][length]; // �ﰢ��ũ�� ��ŭ dp �迭 ����
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
			
			for (int j = 1; j < i+1; j++) { // ���ؼ� ū ���� ����
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }			
		}
        
        for (int i = 0; i < dp[length-1].length; i++) {
			max = Math.max(max, dp[length-1][i]);
		}
        
        System.out.println(max);
        
        return max;
    }
}
