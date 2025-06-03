package BOJ.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ9205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
            for (int i = 0; i < n; i++) {
                list.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    int[] int1 = list.get(i);
                    int[] int2 = list.get(j);
                    if (Math.abs(int1[0] - int2[0]) + Math.abs(int1[1] - int2[1]) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            Deque<Integer> d = new LinkedList<>();
            boolean[] visited = new boolean[n + 2];
            visited[0] = true;
            d.add(0);
            while(!d.isEmpty()) {
                int len = d.size();
                for (int i = 0; i < len; i++) {
                    int cur = d.pollFirst();
                    for(int next: graph.get(cur)) {
                        if(!visited[next]) {
                            visited[next] = true;
                            d.add(next);
                        }
                    }
                }
            }

            System.out.println(visited[n + 1] ? "happy" : "sad");
        }
    }

}
