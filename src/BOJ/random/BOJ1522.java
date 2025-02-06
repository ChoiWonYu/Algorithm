package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int len = input.length();
        int aCnt = 0;
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int rp;
        int curACnt = 0;
        for (rp = 0; rp < aCnt; rp++) {
            if (input.charAt(rp) == 'a') {
                curACnt++;
            }
        }

        int maxACnt = curACnt;
        rp--;
        for (int lp = 0; lp < len; lp++) {
            if (input.charAt(lp) == 'a') {
                curACnt--;
            }
            rp = (rp + 1) % len;
            if(input.charAt(rp) == 'a'){
                curACnt++;
            }
            maxACnt = Math.max(maxACnt, curACnt);
        }

        System.out.println(aCnt - maxACnt);
    }
}
