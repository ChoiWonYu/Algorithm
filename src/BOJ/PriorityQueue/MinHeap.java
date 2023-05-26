package BOJ.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MinHeap {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> minH = new PriorityQueue<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int printNum;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (minH.isEmpty()) printNum = 0;
                else printNum = minH.poll();
                System.out.println(printNum);
            } else {
                minH.add(num);
            }
        }
    }
}
