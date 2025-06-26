package BOJ.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ5052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test_case; i++) {
            int n = sc.nextInt();
            String answer = "YES";
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(sc.next());
            }

            for (String num : set) {
                if (answer.equals("NO")) {
                    break;
                }
                String cur = "";
                for (int j = 0; j < num.length() - 1; j++) {
                    cur += num.charAt(j);
                    if (set.contains(cur)) {
                        answer = "NO";
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
