package Programmers.random;

public class Pr92342 {

    static final int MAX_SCORE = 10;

    static int[] INFO, TMP_INFO, ANSWER;
    static int N, DIFF;

    public int[] solution(int n, int[] info) {
        ANSWER = new int[MAX_SCORE + 1];
        TMP_INFO = new int[MAX_SCORE + 1];
        INFO = info;
        N = n;
        DIFF = 0;

        dfs(0, 0);
        if (DIFF == 0) {
            return new int[]{-1};
        }
        return ANSWER;
    }

    public void dfs(int sum, int curIdx) {
        if (curIdx > MAX_SCORE) {
            int cnt = 0;
            for (int i = 0; i <= MAX_SCORE; i++) {
                cnt += TMP_INFO[i];
            }
            TMP_INFO[MAX_SCORE] = N - cnt;
            refreshMax();
            return;
        }

        // 해당 점수를 획득하지 않을 때
        TMP_INFO[curIdx] = 0;
        dfs(sum, curIdx + 1);

        // 해당 점수를 획득할 때
        if (INFO[curIdx] < N - sum) {
            TMP_INFO[curIdx] = INFO[curIdx] + 1;
            dfs(sum + INFO[curIdx] + 1, curIdx + 1);
        }
    }

    public void refreshMax() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= MAX_SCORE; i++) {
            if (INFO[i] == 0 && TMP_INFO[i] == 0) {
                continue;
            }

            if (INFO[i] > TMP_INFO[i]) {
                sum1 += MAX_SCORE - i;
            } else {
                sum2 += MAX_SCORE - i;
            }
        }

        if (sum2 > sum1 && sum2 - sum1 >= DIFF) {

            // 갱신 가능한지 판단
            if (sum2 - sum1 == DIFF) {
                for (int i = MAX_SCORE; i >= 0; i--) {
                    if (TMP_INFO[i] == ANSWER[i]) {
                        continue;
                    } else if (TMP_INFO[i] > ANSWER[i]) {
                        break;
                    } else {
                        return;
                    }
                }
            }

            // ANSWER 갱신
            DIFF = sum2 - sum1;
            for (int i = 0; i <= 10; i++) {
                ANSWER[i] = TMP_INFO[i];
            }
        }
    }
}
