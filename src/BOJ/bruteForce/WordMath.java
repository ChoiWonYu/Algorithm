package BOJ.bruteForce;

import java.io.*;
import java.util.*;

class Alphabet implements Comparable<Alphabet> {

    char a;
    int n = 0;

    public Alphabet(char ch) {
        a = ch;
    }

    public void add(int n) {
        this.n += n;
    }

    public void multiple(int n) {
        this.n *= n;
    }

    @Override
    public int compareTo(Alphabet o) {
        return o.n - n;
    }
}

public class WordMath {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Character> s = new HashSet<>();
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            inputs[i] = input;
            for (int j = 0; j < input.length(); j++) {
                s.add(input.charAt(j));
            }
        }
        int len = s.size();
        List<Alphabet> alphabets = new ArrayList<>();
        for (char ch : s) {
            alphabets.add(new Alphabet(ch));
        }

        for (String str : inputs) {
            int mul = 1;
            for (int i = str.length() - 1; i >= 0; i--) {
                char target = str.charAt(i);
                for (Alphabet a : alphabets) {
                    if (a.a == target) {
                        a.add(mul);
                        break;
                    }
                }
                mul *= 10;
            }
        }

        Collections.sort(alphabets);

        int start = 9;
        int sum = 0;
        for (Alphabet al : alphabets) {
            al.multiple(start--);
            sum += al.n;
        }

        System.out.println(sum);
    }

}
