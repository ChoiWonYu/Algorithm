package sw.random;

import java.util.Scanner;

public class SW1873 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int dirIdx = -1;
            char[] dir = new char[]{'^', 'v', '<', '>'};
            int[] dirR = new int[]{-1, 1, 0, 0};
            int[] dirC = new int[]{0, 0, -1, 1};
            char[] dirCmd = new char[]{'U', 'D', 'L', 'R'};
            char[][] map = new char[n][m];
            int curR = 0;
            int curC = 0;
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                for (int j = 0; j < m; j++) {
                    map[i][j] = input.charAt(j);
                    for (int k = 0; k < 4; k++) {
                        if (dir[k] == input.charAt(j)) {
                            dirIdx = k;
                            curR = i;
                            curC = j;
                        }
                    }
                }
            }
            sc.nextInt();
            String cmdLines = sc.next();
            for (int i = 0; i < cmdLines.length(); i++) {
                char cmd = cmdLines.charAt(i);
                if (cmd == 'S') {
                    int startR = curR;
                    int startC = curC;
                    while (startR >= 0 && startR < n && startC >= 0 && startC < m) {
                        char curChar = map[startR][startC];
                        if (curChar == '*') {
                            map[startR][startC] = '.';
                            break;
                        } else if (curChar == '#') {
                            break;
                        } else {
                            startR += dirR[dirIdx];
                            startC += dirC[dirIdx];
                        }
                    }

                } else {
                    for (int j = 0; j < dir.length; j++) {
                        if (dirCmd[j] == cmd) {
                            dirIdx = j;
                            map[curR][curC] = dir[dirIdx];
                        }
                    }

                    int nextR = curR + dirR[dirIdx];
                    int nextC = curC + dirC[dirIdx];
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                        && map[nextR][nextC] == '.') {
                        map[nextR][nextC] = map[curR][curC];
                        map[curR][curC] = '.';
                        curR = nextR;
                        curC = nextC;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
