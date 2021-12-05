package 프로그래머스;

/**
 * 프로그래머스 네트워크
 * @author leech
 */
public class Solution_네트워크 {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length]; //방문배열 생성
        
        for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				dfs(i, visited, computers);
				answer++;
			}
		}
		//dfs(0, visited, computers);
		//System.out.println("answer :" +answer);
        return answer;
    }
	
	/** dfs */
	private static void dfs(int idx, boolean[] visited, int[][] computers) {
		visited[idx] = true; // 방문 체크
		//System.out.println(idx);
		
		for (int i = 0; i < visited.length; i++) {
			if(computers[idx][i] == 1 && !visited[i]) { // 방문전 && 인접행렬
				dfs(i, visited, computers);
			}
		}
	}
	
} // end of class