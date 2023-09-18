package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {

    public static int[][] board,dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean[][] visited;
    public static int n,m;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited=new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[]charArr=br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
            board[i][j] =Character.getNumericValue(charArr[j]);
        }
    }

        int min=getMinCnt(new Integer[]{0,0});
        System.out.println(min);

    }

    private static int getMinCnt(Integer[] loc) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(loc);
        int row,col,len,i,tmpRow,tmpCol,j,cnt=0;
        Integer[] curLoc;
        while (!q.isEmpty()) {
            len=q.size();
            cnt++;

            for (i = 0; i < len; i++) {
                curLoc = q.poll();
                row=curLoc[0];
                col = curLoc[1];
                if(row==(n-1)&&col==(m-1))return cnt;
                visited[row][col]=true;


                for (j = 0; j < dir.length; j++) {
                    tmpRow=row+dir[j][0];
                    tmpCol=col+dir[j][1];
                    if(isValidLoc(tmpRow,tmpCol)){
                        visited[tmpRow][tmpCol]=true;
                        q.offer(new Integer[]{tmpRow,tmpCol});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidLoc(int row, int col) {
        return row>=0&&row<n&&col<m&&col>=0&&board[row][col]==1&&!visited[row][col];
    }
}
