package BOJ.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ1159 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String input = sc.next();
            map.put(input.charAt(0), map.getOrDefault(input.charAt(0), 0) + 1);
        }

        TreeSet<Character> set = new TreeSet<>();
        for(char c : map.keySet()) {
            if (map.get(c) >= 5) {
                set.add(c);
            }
        }
        String answer = "PREDAJA";
        if (!set.isEmpty()) {
            answer = "";
            for(char c : set) {
                answer += c;
            }
        }
        System.out.println(answer);
    }

}
