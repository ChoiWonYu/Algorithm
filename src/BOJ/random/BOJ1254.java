package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int evenLen = getEven(input, len);
        int oddLen = getOdd(input, len);
        System.out.println(Math.min(evenLen, oddLen));
    }

    public static int getEven(String input, int len) {
        int midIdx = len;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= len / 2; i--) {
            String s1 = input.substring(i);
            int subLen = s1.length();
            if (i - subLen < 0) {
                break;
            }
            String s2 = input.substring(i - subLen, i);
            sb.append(s2).reverse();
            if (sb.toString().equals(s1)) {
                midIdx = i;
            }
            sb.setLength(0);
        }
        return midIdx * 2;
    }

    public static int getOdd(String input, int len) {
        int midIdx = len - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = midIdx - 1; i >= len / 2; i--) {
            String s1 = input.substring(i + 1);
            int subLen = s1.length();
            if (i - subLen < 0) {
                break;
            }
            String s2 = input.substring(i - subLen, i);
            sb.append(s2).reverse();
            if (sb.toString().equals(s1)) {
                midIdx = i;
            }
            sb.setLength(0);
        }
        return midIdx * 2 + 1;
    }
}
