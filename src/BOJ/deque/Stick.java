package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int stickCnt = 0;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                if(input.charAt(i+1)==')'){
                    result+=stickCnt;
                    i++;
                }
                else{
                    stickCnt++;
                    result++;
                }
            }
            else{
                stickCnt--;
            }
        }
        System.out.println(result);
    }

}
