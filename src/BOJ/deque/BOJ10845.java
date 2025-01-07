package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        int cur;
        String input, cmd;
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            inputArr = input.split(" ");
            cmd = inputArr[0];
            switch (cmd) {
                case "push":
                    d.addLast(Integer.parseInt(inputArr[1]));
                    break;
                case "pop":
                    cur = -1;
                    if (!d.isEmpty()) {
                        cur = d.pollFirst();
                    }
                    System.out.println(cur);
                    break;
                case "size":
                    System.out.println(d.size());
                    break;
                case "empty":
                    cur = d.isEmpty() ? 1 : 0;
                    System.out.println(cur);
                    break;
                case "front":
                    cur = -1;
                    if (!d.isEmpty()) {
                        cur = d.peekFirst();
                    }
                    System.out.println(cur);
                    break;
                case "back":
                    cur = -1;
                    if (!d.isEmpty()) {
                        cur = d.peekLast();
                    }
                    System.out.println(cur);
                    break;
                default:
                    break;
            }
        }
    }
}
