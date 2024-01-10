package BOJ.recursion;

import java.io.*;
import java.util.*;

public class Sum {

    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine());
            recursion(0);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursion(int num) {
        if (num >= n) {
            if (num == n) {
                cnt++;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            recursion(num + i);
        }
    }

}
