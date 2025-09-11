package Programmers.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Pr258711 {

    public int[] solution(int[][] edges) {
        int maxNum = Integer.MIN_VALUE;

        // 최댓값 찾기
        for (int[] e : edges) {
            maxNum = Math.max(maxNum, Math.max(e[0], e[1]));
        }

        // 그래프 생성
        List<Deque<Integer>> graph = new ArrayList<>();
        int[] inCnt = new int[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) {
            graph.add(new LinkedList<>());
        }

        // 그래프 초기화
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            inCnt[to]++;
        }

        // 출발 지점 찾기
        int start = -1;
        for (int i = 1; i <= maxNum; i++) {
            if (inCnt[i] == 0 && graph.get(i).size() >= 2) {
                start = i;
                break;
            }
        }

        int[] answer = new int[]{start, 0, 0, 0};
        for (int n : graph.get(start)) {
            int graphIdx = getGraphIdx(graph, n);
            answer[graphIdx]++;
        }
        return answer;
    }

    /*
     * 도넛: 1, 막대: 2, 8자: 3
     * 도넛: n개의 정점, n개의 간선
     * 막대: n개의 정점, n-1개의 간선
     * 8자: 2n+1개의 정점, 2n+2개의 간선
     */
    public int getGraphIdx(List<Deque<Integer>> graph, int start) {
        Deque<Integer> d = new LinkedList<>();

        d.add(start);
        Set<Integer> vSet = new HashSet<>();
        vSet.add(start);
        int eCnt = 0;
        boolean cycleFlag = false;
        while (!d.isEmpty()) {
            int cur = d.pollFirst();
            while (!graph.get(cur).isEmpty()) {
                int next = graph.get(cur).pollFirst();
                if (vSet.contains(next)) {
                    cycleFlag = true;
                }
                vSet.add(next);
                eCnt++;
                d.addLast(next);
            }
        }

        int vCnt = vSet.size();
        if (vCnt == eCnt) {
            return 1;
        }
        if (!cycleFlag) {
            return 2;
        }
        return 3;
    }
}
