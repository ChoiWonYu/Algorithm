package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n + 1];
        towers[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        int prevValue = 0;
        int answer = 0;
        int cur, prev;
        for (int i = 1; i <= n; i++) {
            cur = towers[i];
            prev = towers[i - 1];
            if (cur > prev) {
                for (int j = prevValue; j >= 0; j--) {
                    if (towers[j] >= cur) {
                        answer = j;
                        break;
                    }
                }
            } else {
                answer = i - 1;
            }
            sb.append(answer).append(" ");
            prevValue = answer;
        }
        System.out.println(sb);
    }
}
