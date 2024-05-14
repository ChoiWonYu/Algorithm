package Programmers.string;

public class RepeatConvert {

    public int zeroSum = 0;

    public int[] solution(String s) {
        int changeCnt = 0;
        String cur = s;
        while (true) {
            cur = convert(cur);
            changeCnt++;
            if (cur.equals("1")) {
                break;
            }
        }
        int[] answer = new int[]{changeCnt, zeroSum};
        return answer;
    }

    public String convert(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroSum++;
                cnt++;
            }
        }
        return Integer.toBinaryString(s.length() - cnt);
    }
}
