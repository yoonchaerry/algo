package 프로그래머스;

import java.util.Arrays;

public class Solution_입국심사 {

	public static void main(String[] args) {
		Solution_입국심사 s = new Solution_입국심사();
		int n = 6;
		int[] times = {7,10};
		//s.solution(n, times);
		System.out.println(s.solution(n, times));
	}
	
	public long solution(int n, int[] times) {
        long answer = 0;
        // times 정렬
        Arrays.sort(times);
        long start = 0;
        long end = (long) n * times[times.length-1]; // 가장 큰 값
        
        while(start < end) {
        	long mid = (start + end) / 2; // 중간 값
        	long sum = 0; // 총 심사한 인원
        	
        	System.out.println(start +","+mid+","+end);
        	
        	for (int i = 0; i < times.length; i++) { // 시간이 짧은 순으로 심사
				sum += mid / times[i];
			}
        	
        	if(sum < n) { // 인원보다 작은 경우 
        		start = mid + 1;
        	}
        	else { // 인원보다 많은 경우
        		end = mid - 1;
        	}
        	answer = mid;
        	
        }
        return answer;
    }

}
