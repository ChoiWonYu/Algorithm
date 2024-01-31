package BOJ.swm;

import java.io.*;
import java.util.*;

public class B9461 {

    static long[] p = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;

        int visitedNum = 1;

        for (int i = 6; i <= 100; i++) {
            p[i] = p[i - 1] + p[visitedNum++];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(p[n]).append("\n");
        }

        System.out.println(sb);
    }

}
