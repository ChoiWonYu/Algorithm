package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HouseNum {

    static int[][] board,dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][]visited;
    static int n;


    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        List<Integer> countList = new ArrayList<>();

        int i,j;
        n=Integer.parseInt(br.readLine());
        int townCnt=0;
        board = new int[n][n];
        visited = new boolean[n][n];


        for (i = 0; i < n; i++) {
            board[i]=br.readLine().chars().map(Character::getNumericValue).toArray();
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(!visited[i][j]&&board[i][j]==1){
                    townCnt++;
                    countList.add(travelHouse(i,j));
                }
            }
        }
        System.out.println(townCnt);
        Collections.sort(countList);
        for(int num:countList) System.out.println(num);
    }

    private static int travelHouse(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int len,i,j,tmpRow,tmpCol,cnt=0;
        int[]cur;

        q.offer(new int[]{row,col});

        while(!q.isEmpty()){
            len=q.size();
            for (i = 0; i < len; i++) {
                cur=q.poll();
                cnt++;
                visited[cur[0]][cur[1]]=true;
                for(j=0;j<4;j++){
                    tmpRow=cur[0]+dir[j][0];
                    tmpCol=cur[1]+dir[j][1];
                    if(isValid(tmpRow,tmpCol)){
                        visited[tmpRow][tmpCol]=true;
                        q.offer(new int[]{tmpRow,tmpCol});
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean isValid(int r, int c) {
        return r>=0&&r<n&&c>=0&&c<n&&!visited[r][c]&&board[r][c]==1;
    }
}
