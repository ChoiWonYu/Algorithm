package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    int diff = k - j;
                    if (j + diff >= m || arr[i][j + diff] != arr[i][j] || i + diff >= n
                        || arr[i + diff][j] != arr[i][j] || arr[i + diff][j + diff] != arr[i][j]) {
                        continue;
                    }
                    answer = Math.max(answer, (int)Math.pow(diff + 1, 2));
                }
            }
        }

        System.out.println(answer);
    }

}
