package BOJ.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class NM9 {

    static int[] nums, print;
    static int n, m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        print = new int[m];

        dfs(0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void dfs(final int depth) {

        if (depth == m) {
            for (int i : print) {
                sb.append(i).append(" ");
            }
            if (!result.contains(sb.toString())) {
                result.add(sb.toString());
            }

            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            print[depth] = nums[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}
