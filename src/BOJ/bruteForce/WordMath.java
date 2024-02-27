package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class WordMath {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphas = new int[26];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int mul = 1;
            for (int j = input.length() - 1; j >= 0; j--) {
                char target = input.charAt(j);
                alphas[target - 'A'] += mul;
                mul *= 10;
            }
        }
        Arrays.sort(alphas);

        int start = 9;
        int sum = 0;
        for (int i = 25; i >= 0; i--) {
            if (alphas[i] == 0) {
                break;
            }
            sum += alphas[i] * start--;
        }
        System.out.println(sum);
    }

}
