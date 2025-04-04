package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class BOJ2668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<Integer> result = new TreeSet<>();
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (i == value) {
                result.add(value);
            }
            nums[i] = value;
        }

        boolean[] visited;
        int next;
        for (int start = 1; start <= n; start++) {
            if (result.contains(start)) {
                continue;
            }
            visited = new boolean[n + 1];
            visited[start] = true;
            next = nums[start];
            while (!visited[next] && next != start) {
                visited[next] = true;
                next = nums[next];
            }

            if (next == start) {
                for (int i = 1; i <= n; i++) {
                    if (visited[i]) {
                        result.add(i);
                    }
                }
            }
        }

        sb.append(result.size()).append("\n");

        for (int answer : result) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}
