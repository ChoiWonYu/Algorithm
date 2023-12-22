package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphabetCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int[] count = new int[26];
        char target;
        for (int i = 0; i < input.length(); i++) {
            target = input.charAt(i);
            count[(int) Character.toLowerCase(target) - 97]++;
        }

        Arrays.stream(count)
            .forEach(cnt -> sb.append(cnt).append(" "));
        System.out.println(sb);
    }

}
