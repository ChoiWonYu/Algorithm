package BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Editor {

    private static final String LEFT = "L";
    private static final String RIGHT = "D";
    private static final String DELETE = "B";
    private static final String APPEND = "P";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> lsb = new LinkedList<>();
        Deque<String> rsb = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String init = br.readLine();
        init.chars()
            .forEach(ch->lsb.add(String.valueOf((char)ch)));
        int num = Integer.parseInt(br.readLine());
        String cmd;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case LEFT :
                    if (lsb.isEmpty()) {
                        continue;
                    }
                    rsb.addFirst(lsb.pollLast());
                    break;
                case RIGHT :
                    if (rsb.isEmpty()) {
                        continue;
                    }
                    lsb.addLast(rsb.pollFirst());
                    break;
                case DELETE :
                    if (lsb.isEmpty()) {
                        continue;
                    }
                    lsb.pollLast();
                    break;
                case APPEND :
                    String appendString = st.nextToken();
                    lsb.addLast(appendString);
                    break;
            }
        }
        lsb.forEach(sb::append);
        rsb.forEach(sb::append);
        System.out.println(sb);
    }
}
