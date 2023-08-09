package inflearn.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato {
  static int[][] tomato;
  static Queue<Integer[]> Q=new LinkedList<>();
  static int[] r=new int []{0,0,1,-1};
  static int[] c=new int []{1,-1,0,0};
  static int M,N,Empty=0,Rotten=0;
  public static int bfs(){
    int day=-1;

    while(!Q.isEmpty()){
      int len=Q.size();
      for(int i=0;i<len;i++){
        Integer[] cur=Q.poll();

        for(int j=0;j<4;j++){
          int row=cur[0]+r[j];
          int col=cur[1]+c[j];
          if(isValidSection(row,col)) {
            tomato[row][col] = 1;
            Q.offer(new Integer[]{row,col});
            Rotten++;
          }
        }
      }
      day++;
    }

    return isAllBeRotten(tomato)?day:-1;
  }

  public static boolean isAllBeRotten(int[][]t){
    return Rotten+Empty==N*M;
  }

  public static boolean isValidSection(int row,int col){
    return row>=0&&row<N&&col>=0&&col<M&&tomato[row][col]!=-1&&tomato[row][col]!=1;
  }



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] firstLine=br.readLine().split(" ");
    M= Integer.parseInt(firstLine[0]);
    N= Integer.parseInt(firstLine[1]);


    tomato=new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] nums=br.readLine().split(" ");
      for(int j=0;j<M;j++) {
        tomato[i][j] = Integer.parseInt(nums[j]);
        if(tomato[i][j]==1) {
          Q.offer(new Integer[]{i, j});
          Rotten++;
        }
        if(tomato[i][j]==-1)Empty++;
      }
    }

    int days=bfs();
    System.out.println(days);


  }

}
