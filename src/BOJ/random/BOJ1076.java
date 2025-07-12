package BOJ.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1076 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();

        String answer = String.valueOf(map.get(s1)) + String.valueOf(map.get(s2));
        for (int i = 0; i < map.get(s3); i++) {
            answer += "0";
        }
        System.out.println(Long.parseLong(answer));
    }

}
