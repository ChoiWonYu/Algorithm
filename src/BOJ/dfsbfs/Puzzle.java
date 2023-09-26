package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Puzzle {

    static int[][] startBoard=new int[3][3];
    static int[][] answerBoard = new int[3][3];
    static boolean[][] visited = new boolean[3][3];
    static int answerRow,answerCol,minCnt=Integer.MAX_VALUE;
    static int count=0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int i,j,inputNum,num=1;
        for (i = 0; i < 3; i++) {
            st=new StringTokenizer(br.readLine());
            for (j = 0; j < 3; j++) {
                inputNum=Integer.parseInt(st.nextToken());

                if(inputNum==0){
                    answerRow=i;
                    answerCol=j;
                }

                answerBoard[i][j] = inputNum;
                startBoard[i][j]=num++;
            }
        }
        startBoard[2][2]=0;
        dfs(2, 2, 0);

        int answer=minCnt==Integer.MAX_VALUE?-1:minCnt;
        System.out.println(answer);
    }

    private static void dfs(int row, int col, int cnt) {

        if(row==answerRow&&col==answerCol&&isCorrect()){
            minCnt=Math.min(minCnt,cnt);
            return;
        }

        int i,tmpRow,tmpCol;

        for (i = 0; i < 4; i++) {
            tmpRow = row + dr[i];
            tmpCol = col + dc[i];

            if(!isValid(tmpRow,tmpCol))continue;

            visited[tmpRow][tmpCol]=true;
            changeLoc(row, col, tmpRow, tmpCol);
            dfs(tmpRow,tmpCol,cnt+1);
            changeLoc(tmpRow, tmpCol, row, col);
            visited[tmpRow][tmpCol]=false;
        }

    }

    private static void changeLoc(int srcRow, int srcCol, int desRow, int desCol) {
        int tmpNum=startBoard[srcRow][srcCol];
        startBoard[srcRow][srcCol]=startBoard[desRow][desCol];
        startBoard[desRow][desCol]=tmpNum;
    }

    private static boolean isCorrect() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(startBoard[i][j]!=answerBoard[i][j])return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col) {
        return row>=0&&row<3&&col>=0&&col<3&&!visited[row][col];
    }
}
