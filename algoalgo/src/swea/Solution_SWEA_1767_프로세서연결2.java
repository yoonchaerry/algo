package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1. �����ڸ� �ھ ����Ʈ�� ���
//2. �ھ� ����Ʈ�� �κ����� ó���Ͽ� �õ��غ� �ھ� ����
//3. ���õ� �ھ�� 4���� ���� ���� �õ�
// ������������ ������ �ִ��� üũ (����:��������->��ŷ/�Ұ���:����)
public class Solution_SWEA_1767_���μ�������2 {
	private static int N, map[][], max, min, totalCnt; // max:�ִ��ھ�, min:�ּ�����
	private static boolean[][] visited;
	private static ArrayList<int[]> list; // �ھ��Ʈ(�����ڸ��� �ƴ� �ھ�)
	private static int[] dr = {-1,1,0,0}; // �����¿�
	private static int[] dc = {0,0,-1,1}; // �����¿�

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N    = Integer.parseInt(br.readLine()); // 7 ��  N �� 12
			map  = new int[N][N];
			list = new ArrayList<int[]>();
			max  = 0;
			min  = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// �����ڸ� �ھ�� ����X
					if(i==0 || i==N-1 || j==0 || j==N-1) continue;
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++; // �����ڸ��� �ƴ� �ھ� ��
					}
				}
			}
			
			go(0,0);
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		} // testcase
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // end of main

	private static void go(int index, int cCnt) {
		if(index == totalCnt) { // ��������
			int res = getLength();
			// ���õ� �ھ� ������ max ����
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}
			else if(max == cCnt) { // �ھ���� ������ �ּ����������� ��
				if(min > res) min = res;
			}
			
			return;
		}
		
		int[] current = list.get(index);
		int r = current[0];
		int c = current[1];
		
		// index core ���� : 4���� �õ�
		for (int d = 0; d < 4; d++) { // ���� �ھ�� ���� �����¿�
			if(isAvailable(r,c,d)) {
				// ���� ����
				setStatus(r,c,d,2);
				// ���� �ھ��
				go(index+1, cCnt+1);
				// ���Ҵ� ���� �����
				setStatus(r,c,d,0);
			}
		}
		
		// index core �̼���
		go(index+1, cCnt);
	}

	private static int getLength() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) res++;
			}
		}
		return res;
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			
			map[nr][nc] = s;
			
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			if(map[nr][nc] >= 1) return false; // �ھ ������ �ִ°��
		}
		return true;
	}

} // end of class
