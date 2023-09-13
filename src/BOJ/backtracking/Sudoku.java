package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sudoku {
    static Integer[][] board = new Integer[9][9];


    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 0) count++;
            }
        }
        dfs(0, 0);
    }

    private static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    private static boolean isValid(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int ind_row = (row / 3) * 3;
        int ind_col = (col / 3) * 3;

        for (int i = ind_row; i < ind_row + 3; i++) {
            for (int j = ind_col; j < ind_col + 3; j++) {
                if (board[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}
