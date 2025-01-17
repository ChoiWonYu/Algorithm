package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());

        List<String> wl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (String w : wl) {
                if (w.startsWith(words[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                wl.add(words[i]);
            }
        }
        System.out.println(wl.size());
    }
}
