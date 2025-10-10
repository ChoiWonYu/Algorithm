package Programmers.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pr42889 {

    public int[] solution(int N, int[] stages) {
        int[] pending = new int[N + 2]; // stages 원소는 N+1까지 있으므로 N+2 크기
        for (int s : stages) {
            pending[s]++;
        }

        List<Fail> failRates = new ArrayList<>();
        int totalPlayers = stages.length;

        for (int i = 1; i <= N; i++) {
            int currentPending = pending[i];

            // 분모가 0일 경우 실패율은 0
            if (totalPlayers == 0) {
                failRates.add(new Fail(i, 0));
            } else {
                failRates.add(new Fail(i, (double) currentPending / totalPlayers));
            }

            // 다음 스테이지에 도달한 사람의 수는 현재 스테이지에 도달한 사람들에서
            // 실패한 사람(도전 중인 사람)을 제외한 수이다.
            totalPlayers -= currentPending;
        }

        // 정렬
        Collections.sort(failRates, (f1, f2) -> {
            if (f1.failPercent == f2.failPercent) {
                return f1.stage - f2.stage;
            }
            return Double.compare(f2.failPercent, f1.failPercent);
        });

        // 결과 반환
        return failRates.stream()
                        .mapToInt(f -> f.stage)
                        .toArray();
    }
}

class Fail {

    public int stage;
    public double failPercent;

    public Fail(int stage, double failPercent) {
        this.stage = stage;
        this.failPercent = failPercent;
    }
}
