package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2239_스도쿠_이재영 {
   private static int[][] map;
   static boolean end;
   static void dfs(int z) {
      if(end) return;
      int x = z/9;
      int y = z%9;
      if(z==80) {
         for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
               System.out.print(map[i][j]);
            }
            System.out.println();
         }
         end=true;
         return;
      }
      
      if(map[x][y] !=0) {
         dfs(z+1);
         return;
      }
      
      
      //3x3 범위구하기
      int r=-1;
      for(int j=0;j<9;j+=3) {
         if(x<j) {
            r=j-3;
            break;
         }
      }
      if(r==-1) r=6;
      int c=-1;
      for(int j=0;j<9;j+=3) {
         if(y<j) {
            c= j-3;
            break;
         }
      }
      if(c==-1) c= 6;
      
      
      for(int i=1;i<=9;i++) {
         //가로
         boolean ok = true;
         for(int j=0;j<9;j++) {
            //if(j==y)continue;
            if(map[x][j]==i) {
               ok=false;
               break;
            }
         }
         if(!ok) continue;
         //세로
         for(int j=0;j<9;j++) {
            //if(j==y)continue;
            if(map[j][y]==i) {
               ok=false;
               break;
            }
         }
         if(!ok) continue;
         //3x3
         
         System.out.println(r+"," + c);
         
ex:         for(int j=r;j<r+3;j++) {
            for(int k=c;k<c+3;k++) {
               if(map[j][k]==i) {
                  ok=false;
                  break ex;
               }
            }
         }
         if(!ok) continue;
         
         map[x][y]=i;
         dfs(z+1);
         if(end) return;
         map[x][y]=0;
      }
      
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      map = new int[9][9];
      
      for(int i=0;i<9;i++) {
         String str = br.readLine();
         for(int j=0;j<9;j++) {
            map[i][j]=str.charAt(j)-'0';
         }
      }
      end = false;
      dfs(0);
   }
}