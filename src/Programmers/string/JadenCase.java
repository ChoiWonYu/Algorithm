package Programmers.string;

public class JadenCase {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == ' ') {
                flag = true;
            } else {
                if (flag) {
                    target = Character.toUpperCase(target);
                    flag = false;
                } else {
                    target = Character.toLowerCase(target);
                }
            }
            sb.append(target);
        }
        return sb.toString();
    }
}
