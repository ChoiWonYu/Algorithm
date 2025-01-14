package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535 {

    public static int[] hp, happy;
    public static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hp = new int[n];
        happy = new int[n];

        StringTokenizer hpst = new StringTokenizer(br.readLine());
        StringTokenizer happySt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hp[i] = Integer.parseInt(hpst.nextToken());
            happy[i] = Integer.parseInt(happySt.nextToken());
        }

        dfs(100, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int curHp, int curHappy, int idx) {
        if (curHp <= 0) {
            return;
        }
        if (idx == n) {
            answer = Math.max(answer, curHappy);
            return;
        }

        dfs(curHp - hp[idx], curHappy + happy[idx], idx + 1);
        dfs(curHp, curHappy, idx + 1);
    }

}
