package ���α׷��ӽ�;

import java.util.Arrays;

public class Solution_�Ա��ɻ� {

	public static void main(String[] args) {
		Solution_�Ա��ɻ� s = new Solution_�Ա��ɻ�();
		int n = 6;
		int[] times = {7,10};
		//s.solution(n, times);
		System.out.println(s.solution(n, times));
	}
	
	public long solution(int n, int[] times) {
        long answer = 0;
        // times ����
        Arrays.sort(times);
        long start = 0;
        long end = (long) n * times[times.length-1]; // ���� ū ��
        
        while(start < end) {
        	long mid = (start + end) / 2; // �߰� ��
        	long sum = 0; // �� �ɻ��� �ο�
        	
        	System.out.println(start +","+mid+","+end);
        	
        	for (int i = 0; i < times.length; i++) { // �ð��� ª�� ������ �ɻ�
				sum += mid / times[i];
			}
        	
        	if(sum < n) { // �ο����� ���� ��� 
        		start = mid + 1;
        	}
        	else { // �ο����� ���� ���
        		end = mid - 1;
        	}
        	answer = mid;
        	
        }
        return answer;
    }

}
