package BOJ.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17406 {

    static int[][] arr;
    static int n, m, k, answer = Integer.MAX_VALUE;
    static List<RotateInfo> rotateList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 정보 구하기
        visited = new boolean[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotateList.add(new RotateInfo(r, c, s));
        }

        solution(0);
        System.out.println(answer);
    }

    public static void solution(int curCnt) {
        if (curCnt == k) {
            // 최솟값 구하기
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += arr[i][j];
                }
                result = Math.min(result, sum);
            }
            answer = Math.min(answer, result);
            return;
        }

        for (int i = 0; i < rotateList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            int[][] tmp = arr;
            visited[i] = true;
            arr = rotate(rotateList.get(i));
            solution(curCnt + 1);
            visited[i] = false;
            arr = tmp;
        }
    }

    private static int[][] rotate(final RotateInfo rotateInfo) {
        int r = rotateInfo.r - 1;
        int c = rotateInfo.c - 1;
        int s = rotateInfo.s;
        int[][] tmpArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpArr[i][j] = arr[i][j];
            }
        }

        for (int d = 1; d <= s; d++) {
            int top = r - d;
            int bottom = r + d;
            int left = c - d;
            int right = c + d;
            int tmp = tmpArr[top][left];
            for (int i = top; i < bottom; i++) {
                tmpArr[i][left] = tmpArr[i + 1][left];
            }
            for (int i = left; i < right; i++) {
                tmpArr[bottom][i] = tmpArr[bottom][i + 1];
            }
            for (int i = bottom; i > top; i--) {
                tmpArr[i][right] = tmpArr[i - 1][right];
            }
            for (int i = right; i > left; i--) {
                tmpArr[top][i] = tmpArr[top][i - 1];
            }
            tmpArr[top][left + 1] = tmp;
        }

        return tmpArr;
    }
}

class RotateInfo {

    int r;
    int c;
    int s;

    public RotateInfo(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}
