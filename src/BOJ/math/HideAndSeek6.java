package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HideAndSeek6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sisNum = Integer.parseInt(st.nextToken());
        int startLoc = Integer.parseInt(st.nextToken());
        int[] sisDistance = new int[sisNum];
        int gcd;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sisNum; i++) {
            sisDistance[i] = Math.abs(Integer.parseInt(st.nextToken()) - startLoc);
        }

        gcd = sisDistance[0];
        for (int i = 1; i < sisNum; i++) {
            gcd = calculateGcd(gcd, sisDistance[i]);
        }

        System.out.println(gcd);
    }

    private static int calculateGcd(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }
        return num1;
    }

}
