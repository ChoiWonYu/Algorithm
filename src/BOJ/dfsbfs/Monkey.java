package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Monkey {

    public static int[][] board, dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}};

    public static int N, M;
    public static boolean[][][]visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int i, j, k, inputInt;
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited= new boolean[k+1][N][M];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = getMinCnt(k);

        System.out.println(min);
    }

    public static int getMinCnt(int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, 0, 0});
        int len, i, j, tmpRow, tmpCol, tmpK, row, col, curK, cnt = 0;
        int[] curInfo;

        while (!q.isEmpty()) {
            len = q.size();
            for (i = 0; i < len; i++) {
                curInfo = q.poll();
                curK = curInfo[0];
                row = curInfo[1];
                col = curInfo[2];

                if (row == N - 1 && col == M - 1) {
                    return cnt;
                }

                int maxDir = curK > 0 ? dir.length : 4;

                for (j = 0; j < maxDir; j++) {
                    tmpRow = row + dir[j][0];
                    tmpCol = col + dir[j][1];

                    tmpK = j > 3 ? curK - 1 : curK;

                    if (!isValid(tmpRow, tmpCol,tmpK)) continue;

                    visited[tmpK][tmpRow][tmpCol]=true;

                    q.offer(new int[]{tmpK, tmpRow, tmpCol});
                }
            }
            cnt++;
        }
        return -1;
    }

    private static boolean isValid(int row, int col, int k) {
        return row >= 0 && row < N && col >= 0 && col < M &&!visited[k][row][col]&& board[row][col] == 0;
    }

}
