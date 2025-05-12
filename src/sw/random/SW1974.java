package sw.random;

import java.util.Scanner;

public class SW1974 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][] board = new int[9][9];
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            sb.append("#").append(test_case).append(" ");
            int result = isValid(board) ? 1 : 0;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isValid(final int[][] board) {
        int[] numCnt;
        // 가로 검증
        for(int i = 0; i < 9; i++) {
            numCnt = new int[10];
            for(int j = 0; j < 9; j++) {
                if(numCnt[board[i][j]] != 0) {
                    return false;
                }
                numCnt[board[i][j]]++;
            }
        }

        // 세로 검증
        for(int i = 0; i < 9; i++) {
            numCnt = new int[10];
            for(int j = 0; j < 9; j++) {
                if(numCnt[board[j][i]] != 0) {
                    return false;
                }
                numCnt[board[j][i]]++;
            }
        }

        // 나머지 검증
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                numCnt = new int[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(numCnt[board[i + k][j + l]] != 0) {
                            return false;
                        }
                        numCnt[board[i + k][j + l]]++;
                    }
                }
            }
        }
        return true;
    }
}
