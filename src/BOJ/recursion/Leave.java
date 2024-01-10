package BOJ.recursion;

import java.util.*;
import java.io.*;

class Talk {

    public int day;
    public int cost;

    public Talk(final int day, final int cost) {
        this.day = day;
        this.cost = cost;
    }
}

public class Leave {

    static int n, result = 0;
    static Talk[] talks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        talks = new Talk[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            talks[i] = new Talk(day, cost);
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(final int day, final int sum) {
        if (day >= n) {
            result = Math.max(result, sum);
            return;
        }

        dfs(day + 1, sum);

        if (day + talks[day].day <= n) {
            dfs(day + talks[day].day, sum + talks[day].cost);
        }
    }

}
