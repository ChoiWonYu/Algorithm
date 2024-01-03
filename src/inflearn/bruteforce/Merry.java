package inflearn.bruteforce;

import java.io.*;
import java.util.*;

public class Merry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[73];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j < e; j++) {
                t[j]++;
            }
        }

        int max = Arrays.stream(t)
            .max()
            .getAsInt();

        System.out.println(max);
    }

}
