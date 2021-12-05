package ����;
/**************************************************************
    Problem: 1037
    User: leechae
    Language: Java
    Result: Success
    Time:219 ms
    Memory:14064 kb
****************************************************************/
 
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main_����_1307_�������� {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder  sb = new StringBuilder();
        StringTokenizer st = null;
         
        int n = Integer.parseInt(br.readLine()); // ����� ũ�� 
        int[][] map = new int[n][n]; // ��� ����
        int[] rowSum = new int[n];   // �� �� 
        int[] colSum = new int[n];   // �� �� 
         
        for (int i = 0; i < n; i++) { // row
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) { // column
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                rowSum[i] += num;
                colSum[j] += num;
            }
        }
         
        // ��, �� ���� ¦�� : OK 
        // 1�� ã���鼭 �����ִ� ��� ���� ��� Ȧ�� �̸� ���� ��� :Change bit (2,3)
        // ������ : Corrupt
        // ��, �� ���� ¦���� �ƴ� ��츦 ī��Ʈ�� �Ѵ�. 
        int r = 0, c = 0;
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            if(rowSum[i] % 2 != 0) {
                r = i+1;
                rowCnt++;
            }
             
            if(colSum[i] % 2 != 0) {
                c = i+1;
                colCnt++;
            }
        }
         
        if(rowCnt==0 && colCnt ==0) { // ���� ���� 
            sb.append("OK");
        }
        else if(rowCnt == colCnt) { // ¦���� �ƴ� ���� ������ �ش� ��Ʈ ã�� �� ���� 
            sb.append("Change bit (").append(r).append(",").append(c).append(")");
        }
        else if(rowCnt != colCnt){ // ���� �ٸ��� ������ 
            sb.append("Corrupt");
        }
         
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    } // end of main
} // end of class