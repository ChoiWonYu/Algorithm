package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rot13 {
    //65, 97, 26
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        char target, result=' ';
        for (int i = 0; i < input.length(); i++) {
            target = input.charAt(i);
            if (Character.isAlphabetic(target)) {
                if(Character.isUpperCase(target)){
                    result = (char)(((target-65)+13)%26+65);
                }
                if (Character.isLowerCase(target)) {
                    result = (char)(((target-97)+13)%26+97);
                }
                sb.append(result);
                continue;
            }
            sb.append(target);
        }
        System.out.println(sb);
    }

}
