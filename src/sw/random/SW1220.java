package sw.random;

import java.util.Scanner;

public class SW1220 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                int nCnt = 0;
                int sCnt = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == 1) {
                        nCnt++;
                    } else if (arr[j][i] == 2) {
                        sCnt++;
                    }
                }

                if (nCnt == 0 || sCnt == 0) {
                    continue;
                }

                int sIdx = 0;
                int nIdx = n - 1;
                while (sIdx < nIdx) {
                    if (arr[sIdx][i] == 2) {
                        sCnt--;
                    }
                    if (arr[sIdx][i] != 1) {
                        sIdx++;
                    }

                    if (arr[nIdx][i] == 1) {
                        nCnt--;
                    }
                    if (arr[nIdx][i] != 2) {
                        nIdx--;
                    }

                    if (arr[sIdx][i] == 1 && arr[nIdx][i] == 2) {
                        break;
                    }
                }
                boolean dlFlag = false;
                for (int k = sIdx; k <= nIdx; k++) {
                    if (arr[k][i] == 1) {
                        dlFlag = true;
                    } else if (arr[k][i] == 2) {
                        if (dlFlag) {
                            answer++;
                        }
                        dlFlag = false;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
