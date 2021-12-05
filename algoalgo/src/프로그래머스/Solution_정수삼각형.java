package 프로그래머스;
/**
 * 프로그래머스 정수삼각형
 * @author leech
 */
public class Solution_정수삼각형 {

	public static void main(String[] args) {
		Solution_정수삼각형 s = new Solution_정수삼각형();
		int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		s.solution(triangle);
	}

	public int solution(int[][] triangle) {
        int max = 0;
        int length = triangle.length;
        int[][] dp = new int[length][length]; // 삼각형크기 만큼 dp 배열 생성
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
			
			for (int j = 1; j < i+1; j++) { // 비교해서 큰 것을 선택
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
