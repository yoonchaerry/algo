package 프로그래머스;

/**
 * 프로그래머스 단어변환
 * @author leech
 */
public class Solution_단어변환 {
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
        	if(!visited[i]) { // 방문하지 않은 경우
        		// 같은 스펠링 몇개인지 세기
        		int cnt = 0; 
        		for (int j = 0; j < begin.length(); j++) {
        			if (begin.charAt(j) == words[i].charAt(j)) {
        				cnt++;
        			}
        		}
        		
        		if (cnt == begin.length()-1) {  // 한글자 빼고 모두 같은 경우
        			visited[i] = true;
        			dfs(words[i], target, words, count+1); // dfs
        			visited[i] = false;
        		}        		
        	}
        }
    }
}