package sw.random;

import java.util.Arrays;
import java.util.Scanner;

public class SW1244 {

    public static int n, max = Integer.MIN_VALUE;
    public static boolean[][] visited = new boolean[11][1000000];

    public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            max = Integer.MIN_VALUE;
            String word = String.valueOf(n);

            dfs(word, k);

            sb.append("#").append(test_case).append(" ").append(max).append("\n");
            for (int i = 0; i <= 10; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        System.out.println(sb);
    }

    private static void dfs(final String word, final int k) {
        if (k == 0) {
            max = Math.max(max, Integer.parseInt(word));
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    continue;
                }
                String newWord = swap(word, i, j);
                int num = Integer.parseInt(newWord);
                if (visited[k][num]) {
                    continue;
                }
                visited[k][num] = true;
                dfs(newWord, k - 1);
            }
        }
    }

    private static String swap(final String word, final int target1, final int target2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i == target1) {
                sb.append(word.charAt(target2));
            } else if (i == target2) {
                sb.append(word.charAt(target1));
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
