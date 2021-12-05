package 정올;
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
 
public class Main_정올_1307_오류교정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder  sb = new StringBuilder();
        StringTokenizer st = null;
         
        int n = Integer.parseInt(br.readLine()); // 행렬의 크기 
        int[][] map = new int[n][n]; // 행렬 생성
        int[] rowSum = new int[n];   // 행 합 
        int[] colSum = new int[n];   // 열 합 
         
        for (int i = 0; i < n; i++) { // row
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) { // column
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                rowSum[i] += num;
                colSum[j] += num;
            }
        }
         
        // 행, 열 합이 짝수 : OK 
        // 1을 찾으면서 속해있는 행과 열이 모두 홀수 이면 변경 대상 :Change bit (2,3)
        // 나머지 : Corrupt
        // 행, 열 합이 짝수가 아닌 경우를 카운트를 한다. 
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
         
        if(rowCnt==0 && colCnt ==0) { // 오류 없음 
            sb.append("OK");
        }
        else if(rowCnt == colCnt) { // 짝수가 아닌 수가 같으면 해당 비트 찾을 수 있음 
            sb.append("Change bit (").append(r).append(",").append(c).append(")");
        }
        else if(rowCnt != colCnt){ // 둘이 다르면 오류임 
            sb.append("Corrupt");
        }
         
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    } // end of main
} // end of class