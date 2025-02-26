package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[30];
        arr[0] = n;

        int cnt = n;
        int answer = 0;
        while (cnt > k) {
            boolean flag = true;
            for (int i = 0; i < 30; i++) {
                int curCnt = arr[i];
                if (curCnt >= 2) {
                    flag = false;
                    cnt += (curCnt / 2 + curCnt % 2 - curCnt);
                    arr[i + 1] += curCnt / 2;
                    arr[i] = curCnt % 2;
                }
            }
            if (flag) {
                arr[0]++;
                cnt++;
                answer++;
            }
        }

        System.out.println(answer);
    }

}
