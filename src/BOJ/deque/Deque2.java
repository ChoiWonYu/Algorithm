package BOJ.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Deque2 {
    public static void main(String[] args)throws Exception {
        Deque<Integer>deque=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int cmd=Integer.parseInt(arr[0]);
            switch (cmd){
                case 1:
                    deque.offerFirst(Integer.parseInt(arr[1]));
                    break;
                case 2:
                    deque.offerLast(Integer.parseInt(arr[1]));
                    break;
                case 3:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.pop()).append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    int num=deque.isEmpty()?1:0;
                    sb.append(num).append("\n");
                    break;
                case 7:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.getFirst()).append("\n");
                    break;
                case 8:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
