package 코테;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		
		int[][] money1 = {{100,3}, {200,1}, {50,2}};
		s.solution(money1);
		
		//int[][] money2 = {{2500,3}, {700,5}};
		//s.solution(money2);
	}
	
	public int solution(int[][] money) {
		int answer = -1;
		int total = 0;
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < money.length; i++) {
			total += money[i][0] * money[i][1];
			cnt   += money[i][1];
		} // 총합 구하기
		
		R = cnt/2;
		mid = total/2;
		input    = new int[cnt];
		selected = new int[R];
		for (int i = 0, idx = 0; i < money.length; i++) {
			for (int j = 0; j < money[i][1]; j++, idx+=1) {
				input[idx] = money[i][0];
			}
		} // input
				
		comb(0, 0, 0);
		System.out.println(min);
		
		return answer;
	}
	
	static int R, mid, cnt;
	static int min;
	static int[] input, selected;
	public void comb(int cnt, int start, int sum) {
		System.out.println(cnt + "," + start + "," + sum);
		if(cnt==R) {
			System.out.println(sum);
			if(min < (mid-sum)) {
				min = mid-sum;
			}
			return;
		}
		
		for (int i = start; i < cnt; i++) {
			selected[cnt] = input[i];
			comb(cnt+1, i+1, sum+input[i]);
		}
	}
}
