package BOJ.random;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new TreeMap<>();
        String input = sc.next();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int lp = 0;
        int rp = input.length() - 1;
        char[] result = new char[input.length()];
        for (char c : map.keySet()) {
            while (map.get(c) != 0 && map.get(c) >= 2) {
                result[lp++] = c;
                result[rp--] = c;
                map.put(c, map.get(c) - 2);
            }
        }
        if (lp < rp) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                result[lp] = c;
                break;
            }
        }
        for (char c : result) {
            System.out.print(c);
        }
    }
}
