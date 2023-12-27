package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int origin = Integer.parseInt(st.nextToken());
        int future = Integer.parseInt(st.nextToken());

        long sum = 0L;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            sum += Long.parseLong(st.nextToken()) * (long) Math.pow(origin, i);
        }
        String result = Long.toString(sum, future);
        result.chars()
                .forEach(ch->{
                    sb.append(Long.parseLong(String.valueOf((char)ch), future)).append(" ");
                });
        System.out.println(sb);
    }
}
