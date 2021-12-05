package ���α׷��ӽ�;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Ÿ�ٳѹ�
 * @author leech
 */
public class Solution_Ÿ�ٳѹ� {

	private static int answer;

	public int solution(int[] numbers, int target) {	
		
		dfs(numbers,target,0,0);
				
		return answer;
	} // end of solution
	
	/**  dfs(numbers, target, idx:�� ��° �ε�������, sum: idx���� ������ ��) */
    private void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){ // ��������
            if(sum == target) answer++;
            return;
        }
        
        // ���� �ε��� ���� ����
        sum+=numbers[idx];
        //dfs ����
        dfs(numbers, target, idx+1, sum);
        
        // ���� �ε��� ���� �ٽ� ��
        sum-=numbers[idx];
        // ���� �ε����� ������ -�� ����
        sum+=(-1 * numbers[idx]);
        // dfs ����
        dfs(numbers, target, idx+1, sum);
    }
} // end of class