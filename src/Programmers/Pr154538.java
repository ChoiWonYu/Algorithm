package Programmers;

import java.util.Deque;
import java.util.LinkedList;

public class Pr154538 {

    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[1000001];
        int answer = 0;
        Deque<Integer> d = new LinkedList<>();
        d.add(x);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int j = 0; j < len; j++) {
                int cur = d.pollFirst();
                if (cur > y || visited[cur]) {
                    continue;
                }
                if (cur == y) {
                    return answer;
                }
                visited[cur] = true;
                d.addLast(cur + n);
                d.addLast(cur * 2);
                d.addLast(cur * 3);
            }
            answer++;
        }
        return -1;
    }
}
