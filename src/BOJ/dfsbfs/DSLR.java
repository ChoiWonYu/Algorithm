package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Result{
    int num;
    String command;

    public Result(int num,String command) {
        this.num=num;
        this.command=command;
    }

    public void setNum(int num) {
        this.num=num;
    }

    public String getCommand() {
        return command;
    }

    public int getNum() {
        return num;
    }
}


public class DSLR {

    public static boolean[]  visited=new boolean[100000];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t,i,init,answer;
        String command;

        t = Integer.parseInt(br.readLine());
        for (i = 0; i < t; i++) {
            visited=new boolean[100000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            init = Integer.parseInt(st.nextToken());
            answer=Integer.parseInt(st.nextToken());
            command = getCmd(init, answer);
            sb.append(command).append("\n");
        }

        System.out.println(sb);
    }

    public static String getCmd(int init,int answer) {
        Queue<Result> q = new LinkedList<>();
        q.offer(new Result(init,""));
        int len,i;
        Result curResult;
        Result[] resultArr=new Result[4];

        while (!q.isEmpty()) {
            len=q.size();
            for (i = 0; i < len; i++) {
                curResult=q.poll();

                if(curResult.getNum()==answer){
                    return curResult.getCommand();
                }

                resultArr[0]=(doD(curResult));
                resultArr[1]=(doS(curResult));
                resultArr[2]=(doL(curResult));
                resultArr[3]=(doR(curResult));

                for (Result r : resultArr) {
                    if(visited[r.getNum()])continue;
                    visited[r.getNum()]=true;
                    q.offer(r);
                }
            }
        }

        return "";
    }

    private static Result doD(Result r) {
        return new Result(r.getNum()*2%10000,r.getCommand()+"D");
    }

    private static Result doS(Result r) {
        int num=r.getNum()==0?9999:r.getNum()-1;
        return new Result(num, r.getCommand() + "S");
    }

    private static Result doL(Result r) {
        int d1=r.getNum()/1000;
        int num=r.getNum()*10%10000+d1;
        return new Result(num, r.getCommand() + "L");
    }

    private static Result doR(Result r) {
        int d4=r.getNum()%10;
        int num=r.getNum()/10+d4*1000;
        return new Result(num, r.getCommand() + "R");
    }
}
