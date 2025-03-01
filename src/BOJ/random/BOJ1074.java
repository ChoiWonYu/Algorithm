package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        long answer = 0;
        long pass = (long) Math.pow(Math.pow(2, n), 2) / 4;
        int rStart = 0;
        int rEnd = (int) Math.pow(2, n) - 1;
        int cStart = 0;
        int cEnd = (int) Math.pow(2, n) - 1;
        while (pass > 0) {
            int rHalf = (rStart + rEnd) / 2;
            int cHalf = (cStart + cEnd) / 2;

            if (rStart <= targetR && targetR <= rHalf && cStart <= targetC && targetC <= cHalf) {
                rEnd = rHalf;
                cEnd = cHalf;
            } else if (rStart <= targetR && targetR <= rHalf && cHalf + 1 <= targetC
                && targetC <= cEnd) {
                rEnd = rHalf;
                cStart = cHalf + 1;
                answer += pass;
            } else if (rHalf + 1 <= targetR && targetR <= rEnd && cStart <= targetC
                && targetC <= cHalf) {

                rStart = rHalf + 1;
                cEnd = cHalf;
                answer += (pass * 2);
            } else {
                rStart = rHalf + 1;
                cStart = cHalf + 1;
                answer += (pass * 3);
            }

            pass /= 4;
        }

        System.out.println(answer);
    }
}
