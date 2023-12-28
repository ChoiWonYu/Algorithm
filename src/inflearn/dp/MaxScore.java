package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Result implements Comparable<Result> {

    int score;
    int time;

    public Result(final int score, final int time) {
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(final Result o) {
        return time - o.time;
    }
}

public class MaxScore {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int timeLimit = Integer.parseInt(st.nextToken());

        int[] dy = new int[timeLimit + 1];
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            results.add(
                new Result(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(results);

        for (int i = 0; i < count; i++) {
            int targetTime = results.get(i).getTime();
            int targetScore = results.get(i).getScore();
            for (int j = timeLimit; j >= targetTime; j--) {
                dy[j] = Math.max(dy[j - targetTime] + targetScore, dy[j]);
            }
        }

        System.out.println(dy[timeLimit]);
    }

}
