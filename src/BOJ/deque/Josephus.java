package BOJ.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Josephus {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> result = new ArrayList<>();

        List<String> origin = new LinkedList<>();
        boolean[] visited = new boolean[5001];

        int i, n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pointer = m - 1;

        IntStream.range(1, n + 1)
            .forEach(num -> origin.add(String.valueOf(num)));

        result.add(origin.get(pointer));
        visited[pointer] = true;

        while (result.size() < n) {
            for (i = 0; i < m; i++) {
                pointer++;
                while (pointer >= n || visited[pointer]) {
                    if (pointer >= n) {
                        pointer = 0;
                        continue;
                    }
                    pointer++;
                }
            }
            visited[pointer] = true;
            result.add(origin.get(pointer));
        }
        System.out.println("<" + String.join(", ", result) + ">");
    }
}
