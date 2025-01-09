package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = -1;

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(Character.toString(input.charAt(j)));
                nums[i][j] = num;
                if (isValid(num)) {
                    answer = Math.max(answer, num);
                }
            }
        }

        for (int ra = -(n + 1); ra < n; ra++) {
            for (int ca = -(m + 1); ca < m; ca++) {
                if (ra == 0 && ca == 0) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int rn = i;
                        int cn = j;
                        int cur = 0;
                        while (rn >= 0 && rn < n && cn >= 0 && cn < m) {
                            cur = cur * 10 + nums[rn][cn];
                            if (isValid(cur)) {
                                answer = Math.max(answer, cur);
                            }
                            rn += ra;
                            cn += ca;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isValid(int n) {
        long tmp = (int) Math.sqrt(n);
        return tmp * tmp == n;
    }
}
