package ���α׷��ӽ�;

/**
 * ���α׷��ӽ� �ܾȯ
 * @author leech
 */
public class Solution_�ܾȯ {
	private static boolean[] visited;
	private static int answer;
	
	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
	
	public static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
        	answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
        	if(!visited[i]) { // �湮���� ���� ���
        		// ���� ���縵 ����� ����
        		int cnt = 0; 
        		for (int j = 0; j < begin.length(); j++) {
        			if (begin.charAt(j) == words[i].charAt(j)) {
        				cnt++;
        			}
        		}
        		
        		if (cnt == begin.length()-1) {  // �ѱ��� ���� ��� ���� ���
        			visited[i] = true;
        			dfs(words[i], target, words, count+1); // dfs
        			visited[i] = false;
        		}        		
        	}
        }
    }
}