package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick> {

    final int area;
    final int height;
    final int weight;

    public Brick(final int area, final int height, final int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    public boolean canStack(final Brick brick) {
        return brick.area > area && brick.weight > weight;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(final Brick o) {
        if (o.weight - weight == 0) {
            return o.area - area;
        }

        return o.weight - weight;
    }
}

public class HighestTower {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        int max, result = 0;
        Brick[] bricks = new Brick[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bricks[i] = new Brick(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(bricks);

        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (bricks[i].canStack(bricks[j])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = bricks[i].getHeight() + max;
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }

}
