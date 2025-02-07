package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1527 {

    static int answer = 0;
    static int aNum, bNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        aNum = Integer.parseInt(a);
        bNum = Integer.parseInt(b);

        dfs(0L);

        System.out.println(answer);
    }

    public static void dfs(long num) {
        if (num > bNum) {
            return;
        }

        if (num >= aNum) {
            answer++;
        }

        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }
}
