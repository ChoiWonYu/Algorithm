package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Alphabet {
//set이 아닌 방문한 alphabet 을 찾는 방법
    public static char[][] board;
    public static Set<Character> s = new HashSet<>();
    public static int N,M,maxCnt= 1;
    public static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static boolean[][] visited;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i,j;
        String input;
        char[]inputArr;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (i = 0; i < N; i++) {
            input=br.readLine();
            inputArr=input.toCharArray();
            for (j = 0; j < M; j++) {
                board[i][j] = inputArr[j];
            }
        }

        dfs(0,0,1);
        System.out.println(maxCnt);
    }

    private static void dfs(int row, int col,int cnt) {
        s.add(board[row][col]);
        maxCnt = Math.max(maxCnt, s.size());

        int i,tmpRow,tmpCol;
        char tarChar;

        for (i= 0; i < 4; i++) {
            tmpRow = row + dir[i][0];
            tmpCol = col + dir[i][1];

            if (!isValid(tmpRow, tmpCol)) continue;

            tarChar=board[tmpRow][tmpCol];

            visited[tmpRow][tmpCol]=true;
            dfs(tmpRow, tmpCol,cnt+1);
            s.remove(tarChar);
            visited[tmpRow][tmpCol]=false;
        }
    }

    private static boolean isDup(int row, int col) {
        char tarChar = board[row][col];
        int originSize,afterSize;

        originSize=s.size();
        s.add(tarChar);
        afterSize=s.size();
        return originSize==afterSize;
    }

    private static boolean isValid(int row, int col) {
        return row>=0&&row<N&&col>=0&&col<M&&!visited[row][col]&&!isDup(row,col);
    }




}
