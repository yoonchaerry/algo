package ���α׷��ӽ�;

/**
 * ���α׷��ӽ� ��Ʈ��ũ
 * @author leech
 */
public class Solution_��Ʈ��ũ {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length]; //�湮�迭 ����
        
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
		visited[idx] = true; // �湮 üũ
		//System.out.println(idx);
		
		for (int i = 0; i < visited.length; i++) {
			if(computers[idx][i] == 1 && !visited[i]) { // �湮�� && �������
				dfs(i, visited, computers);
			}
		}
	}
	
} // end of class