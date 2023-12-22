package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SuffixArr {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            words.add(input.substring(i));
        }
        words.stream()
            .sorted()
            .forEach(word->{
                sb.append(word).append("\n");
            });

        System.out.println(sb);
    }

}
