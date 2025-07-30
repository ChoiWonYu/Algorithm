package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14499 {

    public static void main(String[] args) throws IOException {
        int[] diceNum = new int[6];
        int[][] dirArr = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] nextArr = new int[][]{{2, 3, 1, 4}, {2, 3, 5, 0}, {5, 0, 1, 4}, {0, 5, 1, 4},
            {2, 3, 0, 5}, {2, 3, 4, 1}};
        int curNum = 0;
        int[] pairNum = new int[]{5, 4, 3, 2, 1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int nextR = r + dirArr[dir][0];
            int nextC = c + dirArr[dir][1];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                continue;
            }

            r = nextR;
            c = nextC;
            curNum = nextArr[curNum][dir];
            if (board[r][c] == 0) {
                board[r][c] = diceNum[curNum];
            } else {
                diceNum[curNum] = board[r][c];
                board[r][c] = 0;
            }
            System.out.println(Arrays.toString(diceNum));
            System.out.println("curNum = " + (curNum + 1));
            System.out.println(diceNum[pairNum[curNum]]);
        }
    }

}
