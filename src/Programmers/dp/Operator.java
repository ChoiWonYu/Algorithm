package Programmers.dp;

import java.util.*;

public class Operator {

    public static void main(String[] args) {
        int result = solution(new String[]{"1", "-", "3", "+", "5", "-", "8"});
        System.out.println(result);
    }

    public static int solution(String arr[]) {
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= arr.length / 2; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(String.join("", arr));
        for (int i = 0; i < dp.size() - 1; i++) {
            List<String> cur = dp.get(i);
            for (String str : cur) {
                int opCnt = dp.size() - i;
                for (int j = 1; j <= opCnt; j++) {
                    dp.get(i + 1).add(calculateOp(j, str));
                }
            }
        }

        List<String> nums = dp.get(arr.length / 2);
        int max = nums.stream()
            .mapToInt(Integer::parseInt)
            .max()
            .getAsInt();
        return max;
    }

    public static String calculateOp(int order, String str) {
        String copy = new String(str);
        int cnt = 0;
        Deque<Character> d = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            if ((target == '-' || target == '+') && !d.isEmpty()) {
                cnt++;
                if(cnt == order) {
                    int num1 = d.pollLast();
                    int num2 = str.charAt(++i);
                    if (target == '+') {
                        d.offer((char) ((num1 - '0' + num2 - '0') + '0'));
                    } else{
                        int result = (num1 - '0') - (num2 - '0');
                        if (result < 0 && !d.isEmpty()) {
                            d.poll();
                        }
                        d.offer((char) (result + '0'));
                    }
                    StringBuilder sb = new StringBuilder();
                    d.forEach(sb::append);
                    return sb.toString();
                }
            }
        }
        return "";
    }

}
