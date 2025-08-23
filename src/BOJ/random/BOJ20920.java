package BOJ.random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Word> result = new ArrayList<>();
        for (String word : map.keySet()) {
            result.add(new Word(word, map.get(word)));
        }
        Collections.sort(result, (a,b)->{
            if(a.count == b.count && a.word.length() == b.word.length()) {
                return a.word.compareTo(b.word);
            }
            if (a.count == b.count) {
                return b.word.length() - a.word.length();
            }
            return b.count - a.count;
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Word word : result) {
            bw.write(word.word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Word {

    String word;
    int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
