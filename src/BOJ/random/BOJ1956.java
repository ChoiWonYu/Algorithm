package BOJ.random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1956 {

    static final int INF = 987654321; // 무한대를 나타내는 값 (경로 길이의 합이 int 범위를 넘지 않도록 조정)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c); // 동일한 경로에 여러 가중치가 주어질 경우를 대비
        }

        // 플로이드-워셜 알고리즘 실행
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                // i -> j 경로와 j -> i 경로가 모두 존재해야 사이클이 형성됨
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }

        bw.write((answer == INF ? -1 : answer) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
