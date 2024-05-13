package Programmers.string;

public class MinMax {

    public String solution(String s) {
        String[] stringNumbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stringNumbers.length; i++) {
            int num = Integer.parseInt(stringNumbers[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}
