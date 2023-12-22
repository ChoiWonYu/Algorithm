package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalysisWords {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //소문자, 대문자, 숫자, 공백 순의 카운팅 배열
        String input;
        int i, lowerCnt, upperCnt, numberCnt, spaceCnt;
        char target;
        while ((input = br.readLine()) != null) {
            lowerCnt = 0;
            upperCnt = 0;
            numberCnt = 0;
            spaceCnt = 0;
            for (i = 0; i < input.length(); i++) {
                target = input.charAt(i);
                if (target >= 'a' && target <= 'z') {
                    lowerCnt++;
                    continue;
                }
                if (target >= 'A' && target <= 'Z') {
                    upperCnt++;
                    continue;
                }
                if (target >= '0' && target <= '9') {
                    numberCnt++;
                    continue;
                }
                if (target == ' ') {
                    spaceCnt++;
                }
            }
            sb.append(lowerCnt).append(" ").append(upperCnt).append(" ").append(numberCnt)
                .append(" ").append(spaceCnt).append("\n");
        }
        System.out.println(sb);
    }
}
