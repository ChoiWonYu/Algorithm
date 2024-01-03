package inflearn.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wrestling {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] players = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            players[i][0] = Integer.parseInt(st.nextToken());
            players[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (players[i][0] < players[j][0] && players[i][1] < players[j][1]) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }

}
