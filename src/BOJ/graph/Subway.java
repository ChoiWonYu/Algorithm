package BOJ.graph;

import java.io.*;
import java.util.*;

public class Subway {

    static List<List<Integer>> subway = new ArrayList<>();
    static Set<Integer> cycle = new HashSet<>();
    static boolean[] visited;
    static boolean findCycle;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        subway.add(new ArrayList<>());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            subway.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            subway.get(p1).add(p2);
            subway.get(p2).add(p1);
        }

        //순환선 찾기
        answer = new int[n + 1];
        Arrays.fill(answer, -1);

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            recursion(i, 1, i);
            if (findCycle) {
                cycle.add(i);
                findCycle = false;
                break;
            }
            visited[i] = false;
        }

        //정답 입력하기
        Deque<Integer> d = new LinkedList<>();
        d.addAll(cycle);

        int plus = 1;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                for (int j = 0; j < subway.get(cur).size(); j++) {
                    int target = subway.get(cur).get(j);
                    if (answer[target] != -1) {
                        continue;
                    }

                    answer[target] = plus;
                    d.add(target);
                }
            }
            plus++;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void recursion(final int num, final int cnt, final int start) {

        for (int n : subway.get(num)) {
            //순회했을 때
            if (n == start && cnt > 2) {
                findCycle = true;
                cycle.add(num);
                answer[num] = 0;
                return;
            }

            if (visited[n]) {
                continue;
            }

            visited[n] = true;
            recursion(n, cnt + 1, start);
            visited[n] = false;
            if (findCycle) {
                cycle.add(num);
                return;
            }
        }
    }

}
