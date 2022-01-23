package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Main_����_17471_�Ը��Ǵ��� {
	  static int N, minDiff;
	  static int[] population;
	  static int[][] map;
	  static Set<Integer> nodes;

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    // �� ���� ��
	    N = Integer.valueOf(br.readLine());
	    // ������ �α� �� �迭
	    population = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    // ����Ǿ��ִ� ������ ǥ���ϱ� ���� �迭
	    map = new int[N][N];
	    // ��ü ���� ��ȣ ����
	    nodes = new HashSet<Integer>();
	    // ������ ���ű��� �α� ���� �ּڰ��� ��� ���� ����
	    minDiff = Integer.MAX_VALUE;

	    for (int i = 0; i < N; i++) {
	      nodes.add(i);
	      String[] info = br.readLine().split(" ");

	      // ����� �׷��� 2������ �迭�� ǥ��
	      if (Integer.valueOf(info[0]) > 0) {
	        for (int j = 1; j < info.length; j++) {
	          int dest = Integer.valueOf(info[j]) - 1;
	          map[i][dest] = 1;
	          map[dest][i] = 1;
	        }
	      }
	    }

	    // 1. ���ű� �� ������ 1�� ~ (N+1)/2�� �� ���� ���� ���� ����
	    for (int pick = 1; pick <= (N + 1) / 2; pick++) {
	      solution(pick, 0, new boolean[N]);
	    }

	    minDiff = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
	    bw.write(minDiff + "\n");
	    bw.flush();
	    bw.close();
	  }

	  static void solution(int pick, int start, boolean[] visited) {
	    // 1-2. �� �̾��� ��
	    if (pick == 0) {
	      // 2. ������ A ���� ����
	      Set<Integer> A = new HashSet<Integer>();

	      for (int i = 0; i < N; i++) {
	        if (visited[i])
	          A.add(i);
	      }

	      // 3. ������ B ���� ����
	      Set<Integer> B = new HashSet<Integer>(nodes);
	      B.removeAll(A);

	      // 4. ������ �� ������ ����Ǿ��ִ��� Ȯ��
	      // 4-1. ������ A ���� Ȯ��
	      int aValue = isConnected(A, B);
	      if (aValue == -1)
	        return;

	      // 4-2. ������ B ���� Ȯ��
	      int bValue = isConnected(B, A);
	      if (bValue == -1)
	        return;

	      // 5. �� ���ű��� �α����� �ּ� �α����� ���Ͽ� ����
	      minDiff = Math.min(minDiff, Math.abs(aValue - bValue));

	      return;
	    }

	    // 1-1. ���� ����
	    
	    for (int i = start; i < N; i++) {
	      visited[i] = true;
	      solution(pick - 1, i + 1, visited);
	      visited[i] = false;
	    }

	  }

	  static int isConnected(Set<Integer> set, Set<Integer> diffSet) {
	    // ����� ������ �� �α��� ��� ����
	    int connectValue = 0;
	    // �̹� �湮�� �������� Ȯ���ϱ����� �迭
	    boolean[] visited = new boolean[N];

	    // ����� ���ű� = ������ �� ������ BFS�ϸ� ��� ������ �湮�� �� �־�� ��
	    // BFS ��, �湮 ���� ������ ������ ����Ǿ����� �ʴٴ� �ǹ�
	    Iterator<Integer> iter = set.iterator();
	    int start = iter.next();

	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(start);
	    visited[start] = true;

	    while (!queue.isEmpty()) {
	      int current = queue.poll();

	      for (int i = 0; i < N; i++) {
	        // ���� ����� �����̰�, �湮�� ���� ����, �ٸ� ���ű��� ���ԵǾ����� �ʴ� �����̶�� Ž��
	        if (map[current][i] == 1 && !visited[i] && !diffSet.contains(i)) {
	          queue.add(i);
	          visited[i] = true;
	        }
	      }
	    }

	    // ������ �� ������ �������� �湮 Ž���Ͽ��� ��
	    // ���ű��� ���Ե� ������ �湮�Ǿ����� ������ ���� X
	    for (Integer n : set) {
	      if (!visited[n])
	        return -1;
	      connectValue += population[n];
	    }

	    // ��� �湮�Ǿ����� ����ε� ���ű��� �α��� ����
	    return connectValue;
	  }
} // end of class
