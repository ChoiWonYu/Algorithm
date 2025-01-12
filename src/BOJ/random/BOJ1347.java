package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1347 {

    public static final int LIMIT = 101;

    public static void main(String[] args) throws IOException {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};
        int dirPoint = 0;
        boolean[][] route = new boolean[LIMIT][LIMIT];

        int curX = LIMIT / 2;
        int curY = LIMIT / 2;
        route[curX][curY] = true;

        int minX = curX;
        int maxX = curX;
        int minY = curY;
        int maxY = curY;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            char cmd = input.charAt(i);
            switch (cmd) {
                case 'L':
                    dirPoint = (dirPoint + 1) % 4;
                    break;
                case 'R':
                    dirPoint = (dirPoint - 1 + 4) % 4;
                    break;
                case 'F':
                    curX += dx[dirPoint];
                    curY += dy[dirPoint];
                    route[curX][curY] = true;

                    minX = Math.min(minX, curX);
                    maxX = Math.max(maxX, curX);
                    minY = Math.min(minY, curY);
                    maxY = Math.max(maxY, curY);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxY; i >= minY; i--) {
            for (int j = minX; j <= maxX; j++) {
                if (route[j][i]) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
