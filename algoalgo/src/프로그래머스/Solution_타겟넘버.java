package 프로그래머스;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 타겟넘버
 * @author leech
 */
public class Solution_타겟넘버 {

	private static int answer;

	public int solution(int[] numbers, int target) {	
		
		dfs(numbers,target,0,0);
				
		return answer;
	} // end of solution
	
	/**  dfs(numbers, target, idx:몇 번째 인덱스인지, sum: idx까지 누적된 값) */
    private void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){ // 종료조건
            if(sum == target) answer++;
            return;
        }
        
        // 현재 인덱스 값을 누적
        sum+=numbers[idx];
        //dfs 수행
        dfs(numbers, target, idx+1, sum);
        
        // 현재 인덱스 값을 다시 뺌
        sum-=numbers[idx];
        // 현재 인덱스의 정수를 -로 누적
        sum+=(-1 * numbers[idx]);
        // dfs 수행
        dfs(numbers, target, idx+1, sum);
    }
} // end of class